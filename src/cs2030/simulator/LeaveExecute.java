package cs2030.simulator;

public class LeaveExecute {
    
    public static Pair<Shop, Event> leaveFunc(Customer customer, Shop shop) {
        Shop newShop = new Shop(shop.getServerList());
        return new Pair<Shop, Event>(newShop, null);
    }

}
