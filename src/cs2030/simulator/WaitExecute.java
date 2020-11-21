package cs2030.simulator;

import java.util.Optional;

public class WaitExecute {

    public static Pair<Shop, Event> waitFunc(Customer customer, int serverID, Shop shop) {
        Optional<Server> opServer = shop.find(x -> x.getID()==serverID);
        if(opServer.isPresent()) {
            Server server = opServer.get();
            RandomGen random = new RandomGen();
            Server newserver = new Server(server.getID(), false, true, server.getNextAvailableTime()+random.genServiceTime());
            Shop newShop = shop.replace(newserver);
            Event newEvent = new ServeEvent(customer, server.getNextAvailableTime(), newserver.getID());
            return new Pair<Shop, Event>(newShop, newEvent);
        }
        Shop newShop = new Shop(shop.getServerList());
        return new Pair<Shop, Event>(newShop, null);
    }

}
