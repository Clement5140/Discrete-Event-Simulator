package cs2030.simulator;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class ArriveExecute {
    
    
    /** 
     * ArriveEvent Execute method.
     * 
     * @param customer  customer
     * @param shop  shop
     * @return Pair return a Pair of Shop and Event
     */
    public static Pair<Shop, Event> arriveFunc(Customer customer, Shop shop) {
        Utils utils = new Utils();
        Optional<Server> opServer = shop.find(x -> x.isAvailable() && !x.isResting());
        if (opServer.isPresent()) {
            Server server = opServer.get();
            RandomGen random = new RandomGen();
            if (server.isCounter()) {
                Server newServer = new Server(server.getID(), true,
                    true, 0, customer.getArrivalTime() + random.genServiceTime());
                Shop newShop = shop.replace(newServer);
                Event newEvent = new ServeEvent(customer,
                    customer.getArrivalTime(), newServer.getID());
                return new Pair<Shop, Event>(newShop, newEvent);
            }
            Server newServer = new Server(server.getID(), true,
                server.getnumOfWaitingCustomer() + 1,
                customer.getArrivalTime() + random.genServiceTime(),
                server.getCustomerQueue()).addCustomer(customer);
            Shop newShop = shop.replace(newServer);
            Event newEvent = new ServeEvent(customer,
                customer.getArrivalTime(), newServer.getID());
            return new Pair<Shop, Event>(newShop, newEvent);
        }

        if (customer.isGreedy()) {
            List<Server> serverList = shop.getServerList();
            Server server = serverList.stream().filter(x -> !x.isCounter())
                .min(Comparator.comparing(Server::getnumOfWaitingCustomer)).get();
            if (utils.getNumOfSelfCheckoutCounters() != 0) {
                Server counter = serverList.get(utils.getNumOfServers());
                if (server.getnumOfWaitingCustomer() < utils.getMaxQueueLength()
                    || counter.getNumOfSharingCustomer() < utils.getMaxQueueLength()) {
                    if (server.getnumOfWaitingCustomer() <= counter.getNumOfSharingCustomer()) {
                        Server newServer = new Server(server.getID(), false,
                            server.getnumOfWaitingCustomer(), server.getNextAvailableTime(),
                            server.getCustomerQueue()).addCustomer(customer);
                        Shop newShop = shop.replace(newServer);
                        Event newEvent = new WaitEvent(customer,
                            customer.getArrivalTime(), newServer.getID());
                        return new Pair<Shop, Event>(newShop, newEvent);
                    } else {
                        counter.addSharingCustomer(customer);
                        Event newEvent = new WaitEvent(customer,
                            customer.getArrivalTime(), counter.getID());
                        return new Pair<Shop, Event>(shop, newEvent);
                    }
                }
            } else if (server.getnumOfWaitingCustomer() < utils.getMaxQueueLength()) {
                Server newServer = new Server(server.getID(), false,
                    server.getnumOfWaitingCustomer(), server.getNextAvailableTime(),
                    server.getCustomerQueue()).addCustomer(customer);
                Shop newShop = shop.replace(newServer);
                Event newEvent = new WaitEvent(customer,
                    customer.getArrivalTime(), newServer.getID());
                return new Pair<Shop, Event>(newShop, newEvent);
            }
        } else {
            opServer = shop.find(x -> !x.isCounter()
                && x.getnumOfWaitingCustomer() < utils.getMaxQueueLength());
            if (opServer.isPresent()) {
                Server server = opServer.get();
                Server newServer = new Server(server.getID(), false,
                    server.getnumOfWaitingCustomer(), server.getNextAvailableTime(),
                    server.getCustomerQueue()).addCustomer(customer);
                Shop newShop = shop.replace(newServer);
                Event newEvent = new WaitEvent(customer,
                    customer.getArrivalTime(), newServer.getID());
                return new Pair<Shop, Event>(newShop, newEvent);
            }
            if (utils.getNumOfSelfCheckoutCounters() != 0) {
                List<Server> serverList = shop.getServerList();
                Server counter = serverList.get(utils.getNumOfServers());
                if (counter.getNumOfSharingCustomer() < utils.getMaxQueueLength()) {
                    counter.addSharingCustomer(customer);
                    Event newEvent = new WaitEvent(customer,
                        customer.getArrivalTime(), counter.getID());
                    return new Pair<Shop, Event>(shop, newEvent);
                }
            }
        }

        Shop newShop = new Shop(shop.getServerList());
        Event newEvent = new LeaveEvent(customer, customer.getArrivalTime());
        return new Pair<Shop, Event>(newShop, newEvent);
    }

}
