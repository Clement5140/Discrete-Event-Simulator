package cs2030.simulator;

public class WaitEvent extends Event {
    private final int serverID;

    /** 
     * 构造函数.
     * 
     * @param customer  客户
     * @param eventStartTime    开始时间
     * @param serverID  server的ID
     */
    public WaitEvent(Customer customer, double eventStartTime, int serverID) {
        super(customer, eventStartTime, 2,
            x -> WaitExecute.waitFunc(customer, serverID, x));
        this.serverID = serverID;
    }

    /** 
     * 构造函数.
     * 
     * @param customer  客户
     * @param eventStartTime    开始时间
     * @param serverID  server的ID
     * @param visible   是否打印
     */
    public WaitEvent(Customer customer, double eventStartTime, int serverID, boolean visible) {
        super(customer, eventStartTime, 2,
            x -> WaitExecute.waitFunc(customer, serverID, x), visible);
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
