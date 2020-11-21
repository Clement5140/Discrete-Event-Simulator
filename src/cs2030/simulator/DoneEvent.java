package cs2030.simulator;

import java.util.Optional;

public class DoneEvent extends Event {
    final static Integer priority = 2;
    private final int serverID;

    public DoneEvent(Customer customer, double eventStartTime, int serverID){
        super(customer, eventStartTime, priority, x -> func(customer, serverID, x));
        this.serverID = serverID;
    }

    public static Pair<Shop, Event> func(Customer customer, int serverID, Shop shop) {
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

    @Override
    public String toString(){
        return String.format("%.3f ",this.getEventStartTime()) + this.getCustomer().getID() + " done serving by " +this.serverID;
    }
}
