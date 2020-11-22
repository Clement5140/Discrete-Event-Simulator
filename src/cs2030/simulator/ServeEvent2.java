package cs2030.simulator;

public class ServeEvent2 extends Event {
    private final int serverID;
    
    /** 
     * 构造函数.
     * 
     * @param customer  客户
     * @param eventStartTime    开始时间
     * @param serverID  server的ID
     */
    public ServeEvent2(Customer customer,  double eventStartTime, int serverID) {
        super(customer, eventStartTime, 3, x -> null);
        this.serverID = serverID;
    }

    
    /** 
     * String转换.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return String.valueOf(serverID);
    }

}
