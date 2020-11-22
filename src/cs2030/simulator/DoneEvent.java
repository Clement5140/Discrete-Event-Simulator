package cs2030.simulator;

public class DoneEvent extends Event {
    private final int serverID;

    /** 
     * 构造函数.
     * 
     * @param customer  客户
     * @param eventStartTime    开始时间
     * @param serverID  server的ID
     */
    public DoneEvent(Customer customer, double eventStartTime, int serverID) {
        super(customer, eventStartTime, 2,
            x -> DoneExecute.doneFunc(customer, serverID, x));
        this.serverID = serverID;
    }

    
    /** 
     * String转换.
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
