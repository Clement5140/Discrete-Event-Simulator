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
    public boolean getAvailable(){
        return this.isAvailable;
    }
    public boolean getWaitingCustomer(){
        return this.hasWaitingCustomer;
    }
    public double getNextAvailableTime(){
        return this.nextAvailableTime;
    }

    public boolean isAvailable(){
        return this.isAvailable;
    }

    public Server setState(){
        if(this.isAvailable == true) {
            return new Server(this.identifier, false, this.hasWaitingCustomer, this.nextAvailableTime);
        } else {
            return new Server(this.identifier, true, this.hasWaitingCustomer, this.nextAvailableTime);
        }
    }

    public Server setWaitingCustomer(){
        if(this.hasWaitingCustomer == true){
            return new Server(this.identifier, this.isAvailable, false, this.nextAvailableTime);
        } else {
            return new Server(this.identifier, this.isAvailable, true, this.nextAvailableTime);
        }
    }

    public Server setNextAvailableTime(){
        return new Server(this.identifier, this.isAvailable, this.hasWaitingCustomer, this.nextAvailableTime + 1.0);
    }


    @Override
    public String toString(){
        if(this.isAvailable == true){
            return this.identifier + " is available";
        } else if(this.hasWaitingCustomer == false) {
            return this.identifier + " is busy; available at " +String.format("%.3f", this.nextAvailableTime);
        } else {
            return this.identifier + " is busy; waiting customer to be served at " + String.format("%.3f",this.nextAvailableTime);
        }                  
    }

}
