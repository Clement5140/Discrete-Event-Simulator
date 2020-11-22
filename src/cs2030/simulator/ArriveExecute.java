package cs2030.simulator;

import java.util.Optional;

public class ArriveExecute {
    
    public static Pair<Shop, Event> arriveFunc(Customer customer, Shop shop) {
        Utils utils = new Utils();
        Optional<Server> opServer = shop.find(x -> x.isAvailable() && !x.isResting());
        if(opServer.isPresent()) {
            Server server = opServer.get();
            RandomGen random = new RandomGen();
            Server newserver = new Server(server.getID(), true, server.getnumOfWaitingCustomer()+1, customer.getArrivalTime()+random.genServiceTime(), server.getCustomerQueue()).addCustomer(customer);
            Shop newShop = shop.replace(newserver);
            Event newEvent = new ServeEvent(customer, customer.getArrivalTime(), newserver.getID());
            return new Pair<Shop, Event>(newShop, newEvent);
        }
        opServer = shop.find(x -> x.getnumOfWaitingCustomer()<utils.getMaxQueueLength());
        if(opServer.isPresent()) {
            Server server = opServer.get();
            Server newserver = new Server(server.getID(), false, server.getnumOfWaitingCustomer(), server.getNextAvailableTime(), server.getCustomerQueue()).addCustomer(customer);
            Shop newShop = shop.replace(newserver);
            Event newEvent = new WaitEvent(customer, customer.getArrivalTime(), newserver.getID());
            return new Pair<Shop, Event>(newShop, newEvent);
        }
        Shop newShop = new Shop(shop.getServerList());
        Event newEvent = new LeaveEvent(customer, customer.getArrivalTime());
        return new Pair<Shop, Event>(newShop, newEvent);
    }

}
