package cs2030.simulator;

public class Customer {
    private final int customerID;
    private final double arrivalTime;
    private final boolean isGreedy;
    
    /** 
     * 构造函数.
     * 
     * @param customerID    客户ID
     * @param arrivalTime   到达时间
     */
    public Customer(int customerID, double arrivalTime) {
        this.customerID = customerID;
        this.arrivalTime = arrivalTime;
        this.isGreedy = false;
    }

    /** 
     * 构造函数.
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
     * 客户ID.
     * 
     * @return int
     */
    public int getID() {
        return this.customerID;
    }

    
    /** 
     * 到达时间.
     * 
     * @return double
     */
    public double getArrivalTime() {
        return this.arrivalTime;
    }

    
    /** 
     * 是否贪心.
     * 
     * @return boolean
     */
    public boolean isGreedy() {
        return isGreedy;
    }

    
    /** 
     * String转换.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return this.customerID + " arrives at " + arrivalTime;
    }

}
