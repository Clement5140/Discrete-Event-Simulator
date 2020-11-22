package cs2030.simulator;

public class ArriveEvent extends Event {
    final static Integer priority = 5;

    public ArriveEvent(Customer customer) {
        super(customer, customer.getArrivalTime(), priority, x -> ArriveExecute.arriveFunc(customer, x));
    }

    @Override
    public String toString() {
        return String.format("%.3f ", this.getEventStartTime()) + this.getCustomer().getID() + (this.getCustomer().isGreedy()?"(greedy)":"") + " arrives";
    }

}
