package cs2030.simulator;

public class ServerRestEvent extends Event {
    final static Integer priority = -1;
    private final int serverID;
    
    public ServerRestEvent(Customer customer, double eventStartTime, int serverID){
        super(customer, eventStartTime, priority, x -> ServerRestExecute.restFunc(customer, serverID, x), false);
        this.serverID = serverID;
    }

}
