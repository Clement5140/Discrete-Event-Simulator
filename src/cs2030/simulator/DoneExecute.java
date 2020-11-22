package cs2030.simulator;

import java.util.Optional;

public class DoneExecute {
    
    
    /** 
     * DoneEvent的Execute方法.
     * 
     * @param customer  客户
     * @param serverID  server的ID
     * @param shop      商店
     * @return Pair
     */
    public static Pair<Shop, Event> doneFunc(Customer customer, int serverID, Shop shop) {
        Optional<Server> opServer = shop.find(x -> x.getID() == serverID);
        if (opServer.isPresent()) {
            Server server = opServer.get();
            Utils utils = new Utils();
            RandomGen randomGen = new RandomGen();
            if (serverID <= utils.getNumOfServers()) {
                if (randomGen.genRandomRest() < utils.getRestProbability()) {
                    Server newserver = new Server(server.getID(), true,
                        false, server.getnumOfWaitingCustomer(),
                        server.getNextAvailableTime() + randomGen.genRestPeriod(),
                        server.getCustomerQueue());
                    Shop newShop = shop.replace(newserver);
                    Event newEvent = (server.getnumOfWaitingCustomer() == 0) ?
                        new ServerRestEvent(null, server.getNextAvailableTime(), server.getID()) :
                        new ServerRestEvent(server.getFirstCustomer(),
                            server.getNextAvailableTime(), server.getID());
                    return new Pair<Shop, Event>(newShop, newEvent);
                }
                Server newserver = new Server(server.getID(), true,
                    server.getnumOfWaitingCustomer(),
                    server.getNextAvailableTime(), server.getCustomerQueue());
                Shop newShop = shop.replace(newserver);
                if (server.getnumOfWaitingCustomer() == 0) {
                    return new Pair<Shop, Event>(newShop, null);
                }
                newserver = new Server(server.getID(), true,
                    server.getnumOfWaitingCustomer(),
                    server.getNextAvailableTime() + randomGen.genServiceTime(),
                    server.getCustomerQueue());
                Event newEvent = new ServeEvent2(server.getFirstCustomer(),
                    server.getNextAvailableTime(), server.getID());
                newShop = shop.replace(newserver);
                Statistics.addWaitingTime(server.getNextAvailableTime()
                    - server.getFirstCustomer().getArrivalTime());
                return new Pair<Shop, Event>(newShop, newEvent);
            }
            Server newServer = new Server(server.getID(),
                true, true, 0, server.getNextAvailableTime());
            Shop newShop = shop.replace(newServer);
            // System.out.println(newServer.getID() + " " + newServer.getNumOfSharingCustomer());
            if (newServer.getNumOfSharingCustomer() == 0) {
                return new Pair<Shop, Event>(newShop, null);
            }
            newServer = new Server(server.getID(), true,
                true, 0, server.getNextAvailableTime() + randomGen.genServiceTime());
            newShop = shop.replace(newServer);
            customer = newServer.pollFirstSharingCustomer();
            Event newEvent = new ServeEvent2(customer,
                server.getNextAvailableTime(), newServer.getID());
            Statistics.addWaitingTime(server.getNextAvailableTime() - customer.getArrivalTime());
            return new Pair<Shop, Event>(newShop, newEvent);
        }
        Shop newShop = new Shop(shop.getServerList());
        return new Pair<Shop, Event>(newShop, null);
    }

}
