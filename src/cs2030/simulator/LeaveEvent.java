package cs2030.simulator;

public class LeaveEvent extends Event {
    
    /** 
     * 构造函数.
     * 
     * @param customer  客户
     * @param eventStartTime    开始时间
     */
    public LeaveEvent(Customer customer, double eventStartTime) {
        super(customer, eventStartTime, 1, x -> LeaveExecute.leaveFunc(customer, x));
    }

    
    /** 
     * String转换.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return String.format("%.3f ", this.getEventStartTime())
            + this.getCustomer().getID()
            + (this.getCustomer().isGreedy() ? "(greedy)" : "")
            + " leaves";
    }

}
