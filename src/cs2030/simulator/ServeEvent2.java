package cs2030.simulator;

public class ServeEvent2 extends Event {
    final static Integer priority = 3;
    private final int serverID;
    
    public ServeEvent2(Customer customer,  double eventStartTime, int serverID){
        super(customer, eventStartTime, priority, x -> null);
        this.serverID = serverID;
    }

    @Override
    public String toString(){
        return String.valueOf(serverID);
    }

}
