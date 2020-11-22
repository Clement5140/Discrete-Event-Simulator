package cs2030.simulator;

public class WaitEvent extends Event {
    private final int serverID;

    /** 
     * constructed funcion.
     * 
     * @param customer  customer
     * @param eventStartTime    event start time
     * @param serverID  server identifier
     */
    public WaitEvent(Customer customer, double eventStartTime, int serverID) {
        super(customer, eventStartTime, 2,
            x -> WaitExecute.waitFunc(customer, serverID, x));
        this.serverID = serverID;
    }

    /** 
     * constructed funcion.
     * 
     * @param customer  customer
     * @param eventStartTime    event start time
     * @param serverID  server identifier
     * @param visible   output or not
     */
    public WaitEvent(Customer customer, double eventStartTime, int serverID, boolean visible) {
        super(customer, eventStartTime, 2,
            x -> WaitExecute.waitFunc(customer, serverID, x), visible);
        this.serverID = serverID;
    }

    
    /** 
     * String transform.
     * 
     * @return String
     */
    @Override
    public String toString() {
        Utils utils = new Utils();
        if (this.serverID <= utils.getNumOfServers()) {
            return String.format("%.3f ", this.getEventStartTime())
                + this.getCustomer().getID()
                + (this.getCustomer().isGreedy() ? "(greedy)" : "")
                + " waits to be served by server " + this.serverID;
        }
        return String.format("%.3f ", this.getEventStartTime())
            + this.getCustomer().getID()
            + (this.getCustomer().isGreedy() ? "(greedy)" : "")
            + " waits to be served by self-check " + this.serverID;
    }
}
