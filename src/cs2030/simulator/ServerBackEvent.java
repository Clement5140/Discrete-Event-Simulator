package cs2030.simulator;

public class ServerBackEvent extends Event {
    private final int serverID;
    
    /** 
     * constructed funcion.
     * 
     * @param customer  customer
     * @param eventStartTime    event start time
     * @param serverID  server identifier
     */
    public ServerBackEvent(Customer customer, double eventStartTime, int serverID) {
        super(customer, eventStartTime, 0,
            x -> ServerBackExecute.backFunc(customer, serverID, x), false);
        this.serverID = serverID;
    }

}
