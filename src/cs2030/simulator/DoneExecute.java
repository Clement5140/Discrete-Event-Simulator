package cs2030.simulator;

import java.util.Optional;

public class DoneExecute {
    
    public static Pair<Shop, Event> doneFunc(Customer customer, int serverID, Shop shop) {
        Optional<Server> opServer = shop.find(x -> x.getID()==serverID);
        if(opServer.isPresent()) {
            Server server = opServer.get();
            Server newserver = new Server(server.getID(), true, server.hasWaitingCustomer(), server.getNextAvailableTime());
            Shop newShop = shop.replace(newserver);
            return new Pair<Shop, Event>(newShop, null);
        }
        Shop newShop = new Shop(shop.getServerList());
        return new Pair<Shop, Event>(newShop, null);
    }

}
