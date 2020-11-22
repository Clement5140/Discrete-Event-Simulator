package cs2030.simulator;

import java.util.Optional;

public class ServeExecute {
    
    public static Pair<Shop, Event> serveFunc(Customer customer, int serverID, Shop shop) {
        Optional<Server> opServer = shop.find(x -> x.getID()==serverID);
        if(opServer.isPresent()) {
            Statistics.addServedCustomers();
            Server server = opServer.get();
            Server newserver = new Server(server.getID(), false, server.getnumOfWaitingCustomer()-1, server.getNextAvailableTime(), server.getCustomerQueue()).pollFirstCustomer();
            Shop newShop = shop.replace(newserver);
            Event newEvent = new DoneEvent(customer, server.getNextAvailableTime(), newserver.getID());
            return new Pair<Shop, Event>(newShop, newEvent);
        }
        Shop newShop = new Shop(shop.getServerList());
        return new Pair<Shop, Event>(newShop, null);
    }

}
