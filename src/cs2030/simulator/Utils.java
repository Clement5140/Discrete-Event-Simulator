package cs2030.simulator;

public class Utils {
    private static int numOfServers = 1;
    private static int numOfSelfCheckoutCounters = 0;
    private static int maxQueueLength = 1;
    private static double restProbability = 0.0;
    private static double greedyProbability = 0.0;

    /** 
     * 空构造函数.
     */
    public Utils() {}

    
    /** 
     * 设置server数目.
     * 
     * @param numOfServers  server数目
     */
    public void setNumOfServers(int numOfServers) {
        Utils.numOfServers = numOfServers;
    }

    
    /** 
     * 获取server数目.
     * 
     * @return int
     */
    public int getNumOfServers() {
        return numOfServers;
    }

    
    /** 
     * 设置self-check counter数目.
     * 
     * @param numOfSelfCheckoutCounters self-check counter数目
     */
    public void setNumOfSelfCheckoutCounters(int numOfSelfCheckoutCounters) {
        Utils.numOfSelfCheckoutCounters = numOfSelfCheckoutCounters;
    }

    
    /** 
     * 获取self-check counter数目.
     * 
     * @return int
     */
    public int getNumOfSelfCheckoutCounters() {
        return numOfSelfCheckoutCounters;
    }

    
    /** 
     * 设置等待队列长度的最大值.
     * 
     * @param maxQueueLength    等待队列长度的最大值
     */
    public void setMaxQueueLength(int maxQueueLength) {
        Utils.maxQueueLength = maxQueueLength;
    }

    
    /** 
     * 获取等待队列长度的最大值.
     * 
     * @return int
     */
    public int getMaxQueueLength() {
        return maxQueueLength;
    }

    
    /** 
     * 设置rest概率.
     * 
     * @param restProbability   rest概率
     */
    public void setRestProbability(double restProbability) {
        Utils.restProbability = restProbability;
    }

    
    /** 
     * 获取rest概率.
     * 
     * @return double
     */
    public double getRestProbability() {
        return restProbability;
    }

    
    /** 
     * 设置客户贪心概率.
     * 
     * @param greedyProbability 客户贪心概率
     */
    public void setGreedyProbability(double greedyProbability) {
        Utils.greedyProbability = greedyProbability;
    }

    
    /** 
     * 获取客户贪心概率.
     * 
     * @return double
     */
    public double getGreedyProbability() {
        return greedyProbability;
    }

    
    /** 
     * 取max方法.
     * 
     * @param a 参数一
     * @param b 参数二
     * @return int
     */
    public int max(int a, int b) {
        return a > b ? a : b;
    }

}
