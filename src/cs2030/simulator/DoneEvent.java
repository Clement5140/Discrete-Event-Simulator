package cs2030.simulator;

public class DoneEvent extends Event {
    private final int serverID;

    /** 
     * constructed function.
     * 
     * @param customer  customer
     * @param eventStartTime    event start time
     * @param serverID  server identifier
     */
    public DoneEvent(Customer customer, double eventStartTime, int serverID) {
        super(customer, eventStartTime, 2,
            x -> DoneExecute.doneFunc(customer, serverID, x));
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
            return String.format("%.3f ",this.getEventStartTime())
                + this.getCustomer().getID()
                + (this.getCustomer().isGreedy() ? "(greedy)" : "")
                + " done serving by server " + this.serverID;
        }
        return String.format("%.3f ",this.getEventStartTime())
            + this.getCustomer().getID()
            + (this.getCustomer().isGreedy() ? "(greedy)" : "")
            + " done serving by self-check " + this.serverID;
    }
}
