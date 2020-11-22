package cs2030.simulator;

import java.util.Optional;

public class ServerRestExecute {
    
    public static Pair<Shop, Event> restFunc(Customer customer, int serverID, Shop shop) {
        Optional<Server> opServer = shop.find(x -> x.getID()==serverID);
        if (opServer.isPresent()) {
            Server server = opServer.get();
            Server newserver = new Server(server.getID(), true, true, server.getnumOfWaitingCustomer(), server.getNextAvailableTime(), server.getCustomerQueue());
            Shop newShop = shop.replace(newserver);
            Event newEvent = new ServerBackEvent(customer, server.getNextAvailableTime(), newserver.getID());
            return new Pair<Shop, Event>(newShop, newEvent);
        }
        Shop newShop = new Shop(shop.getServerList());
        return new Pair<Shop, Event>(newShop, null);
    }

}
