package cs2030.simulator;

public class ServerBackEvent extends Event {
    private final int serverID;
    
    /** 
     * 构造函数.
     * 
     * @param customer  客户
     * @param eventStartTime    开始时间
     * @param serverID  server的ID
     */
    public ServerBackEvent(Customer customer, double eventStartTime, int serverID) {
        super(customer, eventStartTime, 0,
            x -> ServerBackExecute.backFunc(customer, serverID, x), false);
        this.serverID = serverID;
    }

}
