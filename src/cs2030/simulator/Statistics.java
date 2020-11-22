package cs2030.simulator;

public class Statistics {
    private static double totalWaitingTime = 0;
    private static int numOfServedCustomers = 0;
    private static int numOfCustomers = 0;

    
    /** 
     * set customer number.
     * 
     * @param numOfCustomers   customer number
     */
    public static void setNumOfCustomers(int numOfCustomers) {
        Statistics.numOfCustomers = numOfCustomers;
    }

    
    /** 
     * add waiting time.
     * 
     * @param t adding time
     */
    public static void addWaitingTime(double t) {
        totalWaitingTime += t;
    }

    /** 
     * total served customers.
     */
    public static void addServedCustomers() {
        numOfServedCustomers++;
    }
    
    /** 
     * total waiting time.
     * 
     * @return double
     */
    public static double getTotalWaitingTime() {
        return totalWaitingTime;
    }

    
    /** 
     * average waiting time.
     * 
     * @return double
     */
    public static double getAverageWaitingTime() {
        if (numOfServedCustomers == 0) {
            return 0.0;
        }
        return totalWaitingTime / (double)numOfServedCustomers;
    }

    
    /** 
     * get number of served customers.
     * 
     * @return int
     */
    public static int getServedCustomers() {
        return numOfServedCustomers;
    }

    
    /** 
     * get number of left customers.
     * 
     * @return int
     */
    public static int getLeftCustomers() {
        return numOfCustomers - numOfServedCustomers;
    }

}
