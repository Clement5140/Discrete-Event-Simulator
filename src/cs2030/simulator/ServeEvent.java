package cs2030.simulator;

import java.util.Optional;

public class ServeEvent extends Event {
    final static Integer priority = 3;
    private final int serverID;
    
    public ServeEvent(Customer customer,  double eventStartTime, int serverID){
        super(customer, eventStartTime, priority, x -> func(customer, serverID, x));
        this.serverID = serverID;
    }

    public static Pair<Shop, Event> func(Customer customer, int serverID, Shop shop) {
        Optional<Server> opServer = shop.find(x -> x.getID()==serverID);
        if(opServer.isPresent()) {
            Statistics.addServedCustomers();
            Server server = opServer.get();
            Server newserver = new Server(server.getID(), false, false, server.getNextAvailableTime());
            Shop newShop = shop.replace(newserver);
            Event newEvent = new DoneEvent(customer, server.getNextAvailableTime(), newserver.getID());
            return new Pair<Shop, Event>(newShop, newEvent);
        }
        Shop newShop = new Shop(shop.getServerList());
        return new Pair<Shop, Event>(newShop, null);
    }

    @Override
    public String toString(){
        return String.format("%.3f ", this.getEventStartTime())  + this.getCustomer().getID() + " served by " + this.serverID;
    }
}
