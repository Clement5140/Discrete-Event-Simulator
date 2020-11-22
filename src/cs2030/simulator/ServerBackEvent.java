package cs2030.simulator;

public class ServerBackEvent extends Event {
    final static Integer priority = 0;
    private final int serverID;
    
    public ServerBackEvent(Customer customer, double eventStartTime, int serverID){
        super(customer, eventStartTime, priority, x -> ServerBackExecute.backFunc(customer, serverID, x), false);
        this.serverID = serverID;
    }

}
