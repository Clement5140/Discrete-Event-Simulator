package cs2030.simulator;

import java.util.Optional;

public class ArriveExecute {
    
    public static Pair<Shop, Event> arriveFunc(Customer customer, Shop shop) {
        Optional<Server> opServer = shop.find(x -> x.isAvailable());
        if(opServer.isPresent()) {
            Server server = opServer.get();
            RandomGen random = new RandomGen();
            Server newserver = new Server(server.getID(), true, false, customer.getArrivalTime()+random.genServiceTime());
            Shop newShop = shop.replace(newserver);
            Event newEvent = new ServeEvent(customer, customer.getArrivalTime(), newserver.getID());
            return new Pair<Shop, Event>(newShop, newEvent);
        }
        opServer = shop.find(x -> !x.hasWaitingCustomer());
        if(opServer.isPresent()) {
            Server server = opServer.get();
            Server newserver = new Server(server.getID(), false, false, server.getNextAvailableTime());
            Shop newShop = shop.replace(newserver);
            Event newEvent = new WaitEvent(customer, customer.getArrivalTime(), newserver.getID());
            Statistics.addWaitingTime(server.getNextAvailableTime() - customer.getArrivalTime());
            return new Pair<Shop, Event>(newShop, newEvent);
        }
        Shop newShop = new Shop(shop.getServerList());
        Event newEvent = new LeaveEvent(customer, customer.getArrivalTime());
        return new Pair<Shop, Event>(newShop, newEvent);
    }

}
