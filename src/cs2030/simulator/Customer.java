package cs2030.simulator;

public class Customer {
    private final int customerID;
    private final double arrivalTime;
    private final boolean isGreedy;
    
    /** 
     * constructed funcion.
     * 
     * @param customerID    customer ID
     * @param arrivalTime   arrive time
     */
    public Customer(int customerID, double arrivalTime) {
        this.customerID = customerID;
        this.arrivalTime = arrivalTime;
        this.isGreedy = false;
    }

    /** 
     * constructed funcion.
     * 
     * @param customerID    客户ID
     * @param arrivalTime   到达时间
     * @param isGreedy      是否贪心
     */
    public Customer(int customerID, double arrivalTime, boolean isGreedy) {
        this.customerID = customerID;
        this.arrivalTime = arrivalTime;
        this.isGreedy = isGreedy;
    }

    
    /** 
     * get customer ID.
     * 
     * @return int
     */
    public int getID() {
        return this.customerID;
    }

    
    /** 
     * get arrive time.
     * 
     * @return double
     */
    public double getArrivalTime() {
        return this.arrivalTime;
    }

    
    /** 
     * get greedy or not.
     * 
     * @return boolean
     */
    public boolean isGreedy() {
        return isGreedy;
    }

    
    /** 
     * String transform.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return this.customerID + " arrives at " + arrivalTime;
    }

}
