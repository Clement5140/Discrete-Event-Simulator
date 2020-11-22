package cs2030.simulator;

public class ServeEvent2 extends Event {
    private final int serverID;
    
    /** 
     * constructed funcion.
     * 
     * @param customer  customer
     * @param eventStartTime    event start time
     * @param serverID  server identifier
     */
    public ServeEvent2(Customer customer,  double eventStartTime, int serverID) {
        super(customer, eventStartTime, 3, x -> null);
        this.serverID = serverID;
    }

    
    /** 
     * String transform.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return String.valueOf(serverID);
    }

}
