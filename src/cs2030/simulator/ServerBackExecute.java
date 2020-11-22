package cs2030.simulator;

import java.util.Optional;

public class ServerBackExecute {

    
    /** 
     * ServeBackEvent的Execute方法.
     * 
     * @param customer  客户
     * @param serverID  server的ID
     * @param shop      商店
     * @return Pair
     */
    public static Pair<Shop, Event> backFunc(Customer customer, int serverID, Shop shop) {
        Optional<Server> opServer = shop.find(x -> x.getID() == serverID);
        if (opServer.isPresent()) {
            Server server = opServer.get();
            if (customer == null) {
                if (server.getnumOfWaitingCustomer() == 0) {
                    Server newserver = new Server(server.getID(),
                        true, false, server.getnumOfWaitingCustomer(),
                        server.getNextAvailableTime(), server.getCustomerQueue());
                    Shop newShop = shop.replace(newserver);
                    return new Pair<Shop, Event>(newShop, null);
                }
                customer = server.getFirstCustomer();
            }
            RandomGen randomGen = new RandomGen();
            Server newserver = new Server(server.getID(), true,
                server.getnumOfWaitingCustomer(),
                server.getNextAvailableTime() + randomGen.genServiceTime(),
                server.getCustomerQueue());
            Event newEvent = new ServeEvent2(customer,
                server.getNextAvailableTime(), server.getID());
            Shop newShop = shop.replace(newserver);
            Statistics.addWaitingTime(server.getNextAvailableTime()
                - customer.getArrivalTime());
            return new Pair<Shop, Event>(newShop, newEvent);
        }
        Shop newShop = new Shop(shop.getServerList());
        return new Pair<Shop, Event>(newShop, null);
    }

}
