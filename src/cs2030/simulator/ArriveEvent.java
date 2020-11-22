package cs2030.simulator;

public class ArriveEvent extends Event {

    public ArriveEvent(Customer customer) {
        super(customer, customer.getArrivalTime(),
            5, x -> ArriveExecute.arriveFunc(customer, x));
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
            + " arrives";
    }

}
