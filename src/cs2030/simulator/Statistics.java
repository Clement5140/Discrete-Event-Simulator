package cs2030.simulator;

public class Statistics {
    private static double totalWaitingTime = 0;
    private static int numOfServedCustomers = 0;
    private static int numOfCustomers = 0;

    
    /** 
     * 设置客户数目.
     * 
     * @param numOfCustomers   客户数目
     */
    public static void setNumOfCustomers(int numOfCustomers) {
        Statistics.numOfCustomers = numOfCustomers;
    }

    
    /** 
     * 累计等待时间.
     * 
     * @param t 要累计的时间
     */
    public static void addWaitingTime(double t) {
        totalWaitingTime += t;
    }

    /** 
     * 累计接受服务的客户数目.
     * 
     */
    public static void addServedCustomers() {
        numOfServedCustomers++;
    }
    
    /** 
     * 获取总等待时间.
     * 
     * @return double
     */
    public static double getTotalWaitingTime() {
        return totalWaitingTime;
    }

    
    /** 
     * 获取平均等待时间.
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
     * 获取接受服务的客户数目.
     * 
     * @return int
     */
    public static int getServedCustomers() {
        return numOfServedCustomers;
    }

    
    /** 
     * 获取离开的客户数目.
     * 
     * @return int
     */
    public static int getLeftCustomers() {
        return numOfCustomers - numOfServedCustomers;
    }

}
