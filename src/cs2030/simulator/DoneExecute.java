package cs2030.simulator;

import java.util.Optional;

public class DoneExecute {
    
    public static Pair<Shop, Event> doneFunc(Customer customer, int serverID, Shop shop) {
        Optional<Server> opServer = shop.find(x -> x.getID()==serverID);
        if (opServer.isPresent()) {
            Server server = opServer.get();
            Server newserver = new Server(server.getID(), true, server.getnumOfWaitingCustomer(), server.getNextAvailableTime(), server.getCustomerQueue());
            Shop newShop = shop.replace(newserver);
            if (server.getnumOfWaitingCustomer() == 0)
                return new Pair<Shop, Event>(newShop, null);
            RandomGen random = new RandomGen();
            newserver = new Server(server.getID(), true, server.getnumOfWaitingCustomer(), server.getNextAvailableTime()+random.genServiceTime(), server.getCustomerQueue());
            Event newEvent = new ServeEvent2(server.getFirstCustomer(), server.getNextAvailableTime(), newserver.getID());
            newShop = shop.replace(newserver);
            Statistics.addWaitingTime(server.getNextAvailableTime() - server.getFirstCustomer().getArrivalTime());
            return new Pair<Shop, Event>(newShop, newEvent);
        }
        Shop newShop = new Shop(shop.getServerList());
        return new Pair<Shop, Event>(newShop, null);
    }

}
