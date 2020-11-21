package cs2030.simulator;

public class Server{
    private final int identifier;
    private final boolean isAvailable;
    private final boolean hasWaitingCustomer;
    private final double nextAvailableTime;

    public Server(int identifier, boolean isAvailable, boolean hasWaitingCustomer, double nextAvailableTime) {
        this.identifier = identifier;
        this.isAvailable = isAvailable;
        this.hasWaitingCustomer = hasWaitingCustomer;
        this.nextAvailableTime = nextAvailableTime;
    }

    public int getID(){
        return this.identifier;
    }
    public boolean isAvailable(){
        return this.isAvailable;
    }
    public boolean hasWaitingCustomer(){
        return this.hasWaitingCustomer;
    }
    public double getNextAvailableTime(){
        return this.nextAvailableTime;
    }

    @Override
    public String toString(){
        if(this.isAvailable == true){
            return this.identifier + " is available";
        } else if(this.hasWaitingCustomer == false) {
            return this.identifier + " is busy; available at " + String.format("%.3f", this.nextAvailableTime);
        } else {
            return this.identifier + " is busy; waiting customer to be served at " + String.format("%.3f",this.nextAvailableTime);
        }                  
    }

}
