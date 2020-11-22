package cs2030.simulator;

public class Customer{
    private final int customerID;
    private final double arrivalTime;
    private final boolean isGreedy;
    
    public Customer(int customerID, double arrivalTime){
        this.customerID = customerID;
        this.arrivalTime = arrivalTime;
        this.isGreedy = false;
    }

    public Customer(int customerID, double arrivalTime, boolean isGreedy){
        this.customerID = customerID;
        this.arrivalTime = arrivalTime;
        this.isGreedy = isGreedy;
    }

    public int getID(){
        return this.customerID;
    }

    public double getArrivalTime(){
        return this.arrivalTime;
    }

    public boolean isGreedy() {
        return isGreedy;
    }

    @Override
    public String toString(){
        return this.customerID + " arrives at " + arrivalTime;
    }

}
