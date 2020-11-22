package cs2030.simulator;

public class WaitEvent extends Event {
    final static Integer priority = 4;
    private final int serverID;

    public WaitEvent(Customer customer, double eventStartTime, int serverID){
        super(customer, eventStartTime, priority, x -> WaitExecute.waitFunc(customer, serverID, x));
        this.serverID = serverID;
    }

    public WaitEvent(Customer customer, double eventStartTime, int serverID, boolean visible){
        super(customer, eventStartTime, priority, x -> WaitExecute.waitFunc(customer, serverID, x), visible);
        this.serverID = serverID;
    }

    @Override
    public String toString(){
        return String.format("%.3f ", this.getEventStartTime()) + this.getCustomer().getID() + " waits to be served by server " + this.serverID;
    }
}
