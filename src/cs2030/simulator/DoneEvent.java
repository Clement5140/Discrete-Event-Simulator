package cs2030.simulator;

public class DoneEvent extends Event {
    final static Integer priority = 2;
    private final int serverID;

    public DoneEvent(Customer customer, double eventStartTime, int serverID){
        super(customer, eventStartTime, priority, x -> DoneExecute.doneFunc(customer, serverID, x));
        this.serverID = serverID;
    }

    @Override
    public String toString(){
        return String.format("%.3f ",this.getEventStartTime()) + this.getCustomer().getID() + " done serving by server " +this.serverID;
    }
}
