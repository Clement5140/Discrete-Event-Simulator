package cs2030.simulator;

public class LeaveEvent extends Event {
    final static Integer priority = 1;
    
    public LeaveEvent(Customer customer, double eventStartTime){
        super(customer, eventStartTime, priority, x -> func(customer, x));
    }

    public static Pair<Shop, Event> func(Customer customer, Shop shop) {
        Shop newShop = new Shop(shop.getServerList());
        return new Pair<Shop, Event>(newShop, null);
    }

    @Override
    public String toString(){
        return String.format("%.3f ", this.getEventStartTime()) + this.getCustomer().getID() + " leaves" ;
    }

}
