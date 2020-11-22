package cs2030.simulator;

import java.util.Optional;

public class WaitExecute {

    public static Pair<Shop, Event> waitFunc(Customer customer, int serverID, Shop shop) {
        Optional<Server> opServer = shop.find(x -> x.getID()==serverID);
        if(opServer.isPresent()) {
            Server server = opServer.get();
            if(server.getFirstCustomer() == customer) {
                Server newserver = new Server(server.getID(), false, server.getnumOfWaitingCustomer()+1, server.getNextAvailableTime(), server.getCustomerQueue());
                Shop newShop = shop.replace(newserver);
                return new Pair<Shop, Event>(newShop, null);
            }
            Server newserver = new Server(server.getID(), server.isAvailable(), server.getnumOfWaitingCustomer()+1, server.getNextAvailableTime(), server.getCustomerQueue());
            Shop newShop = shop.replace(newserver);
            return new Pair<Shop, Event>(newShop, null);
        }
        Shop newShop = new Shop(shop.getServerList());
        return new Pair<Shop, Event>(newShop, null);
    }

}
