package cs2030.simulator;

public class LeaveEvent extends Event {
    
    /** 
     * constructed funcion.
     * 
     * @param customer  customer
     * @param eventStartTime    event start time
     */
    public LeaveEvent(Customer customer, double eventStartTime) {
        super(customer, eventStartTime, 1, x -> LeaveExecute.leaveFunc(customer, x));
    }

    
    /** 
     * String transform.
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
