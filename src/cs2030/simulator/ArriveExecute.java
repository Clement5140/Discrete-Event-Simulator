package cs2030.simulator;

import java.util.List;
import java.util.Optional;

public class ArriveExecute {
    
    public static Pair<Shop, Event> arriveFunc(Customer customer, Shop shop) {
        Utils utils = new Utils();
        Optional<Server> opServer = shop.find(x -> x.isAvailable() && !x.isResting());
        if (opServer.isPresent()) {
            Server server = opServer.get();
            RandomGen random = new RandomGen();
            if (server.isCounter()) {
                Server newServer = new Server(server.getID(), true, true, 0, customer.getArrivalTime()+random.genServiceTime());
                Shop newShop = shop.replace(newServer);
                Event newEvent = new ServeEvent(customer, customer.getArrivalTime(), newServer.getID());
                return new Pair<Shop, Event>(newShop, newEvent);
            }
            Server newServer = new Server(server.getID(), true, server.getnumOfWaitingCustomer()+1, customer.getArrivalTime()+random.genServiceTime(), server.getCustomerQueue()).addCustomer(customer);
            Shop newShop = shop.replace(newServer);
            Event newEvent = new ServeEvent(customer, customer.getArrivalTime(), newServer.getID());
            return new Pair<Shop, Event>(newShop, newEvent);
        }

        opServer = shop.find(x -> !x.isCounter() && x.getnumOfWaitingCustomer()<utils.getMaxQueueLength());
        if (opServer.isPresent()) {
            Server server = opServer.get();
            Server newServer = new Server(server.getID(), false, server.getnumOfWaitingCustomer(), server.getNextAvailableTime(), server.getCustomerQueue()).addCustomer(customer);
            Shop newShop = shop.replace(newServer);
            Event newEvent = new WaitEvent(customer, customer.getArrivalTime(), newServer.getID());
            return new Pair<Shop, Event>(newShop, newEvent);
        }
        if (utils.getNumOfSelfCheckoutCounters() != 0) {
            List<Server> serverList = shop.getServerList();
            Server counter = serverList.get(utils.getNumOfServers());
            if (counter.getNumOfSharingCustomer() < utils.getMaxQueueLength()) {
                counter.addSharingCustomer(customer);
                Event newEvent = new WaitEvent(customer, customer.getArrivalTime(), counter.getID());
                return new Pair<Shop, Event>(shop, newEvent);
            }
        }
        Shop newShop = new Shop(shop.getServerList());
        Event newEvent = new LeaveEvent(customer, customer.getArrivalTime());
        return new Pair<Shop, Event>(newShop, newEvent);
    }

}
