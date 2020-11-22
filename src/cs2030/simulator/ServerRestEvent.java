package cs2030.simulator;

public class ServerRestEvent extends Event {
    private final int serverID;
    
    /** 
     * 构造函数.
     * 
     * @param customer  客户
     * @param eventStartTime    开始时间
     * @param serverID  server的ID
     */
    public ServerRestEvent(Customer customer, double eventStartTime, int serverID) {
        super(customer, eventStartTime, -1,
            x -> ServerRestExecute.restFunc(customer, serverID, x), false);
        this.serverID = serverID;
    }

}
