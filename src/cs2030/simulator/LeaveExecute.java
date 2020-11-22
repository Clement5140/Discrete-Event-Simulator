package cs2030.simulator;

public class LeaveExecute {
    
    
    /** 
     * LeaveEvent的Execute方法.
     * 
     * @param customer  客户
     * @param shop      商店
     * @return Pair
     */
    public static Pair<Shop, Event> leaveFunc(Customer customer, Shop shop) {
        Shop newShop = new Shop(shop.getServerList());
        return new Pair<Shop, Event>(newShop, null);
    }

}
