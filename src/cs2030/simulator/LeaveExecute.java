package cs2030.simulator;

public class LeaveExecute {
    
    
    /** 
     * LeaveEvent Execute method.
     * 
     * @param customer  customer
     * @param shop      shop
     * @return Pair
     */
    public static Pair<Shop, Event> leaveFunc(Customer customer, Shop shop) {
        Shop newShop = new Shop(shop.getServerList());
        return new Pair<Shop, Event>(newShop, null);
    }

}
