package cs2030.simulator;

public class ServeEvent extends Event {
    final static Integer priority = 3;
    private final int serverID;
    
    public ServeEvent(Customer customer,  double eventStartTime, int serverID){
        super(customer, eventStartTime, priority, x -> ServeExecute.serveFunc(customer, serverID, x));
        this.serverID = serverID;
    }

    @Override
    public String toString(){
        return String.format("%.3f ", this.getEventStartTime())  + this.getCustomer().getID() + " served by server " + this.serverID;
    }
}
