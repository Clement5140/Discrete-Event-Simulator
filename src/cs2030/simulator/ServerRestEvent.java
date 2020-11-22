package cs2030.simulator;

public class ServerRestEvent extends Event {
    private final int serverID;
    
    /** 
     * constructed function.
     * 
     * @param customer  customer
     * @param eventStartTime    event start time
     * @param serverID  server identifier
     */
    public ServerRestEvent(Customer customer, double eventStartTime, int serverID) {
        super(customer, eventStartTime, -1,
            x -> ServerRestExecute.restFunc(customer, serverID, x), false);
        this.serverID = serverID;
    }

}
