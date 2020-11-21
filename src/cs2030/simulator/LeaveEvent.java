package cs2030.simulator;

public class LeaveEvent extends Event {
    final static Integer priority = 1;
    
    public LeaveEvent(Customer customer, double eventStartTime){
        super(customer, eventStartTime, priority, x -> LeaveExecute.leaveFunc(customer, x));
    }

    @Override
    public String toString(){
        return String.format("%.3f ", this.getEventStartTime()) + this.getCustomer().getID() + " leaves" ;
    }

}
