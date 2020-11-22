package cs2030.simulator;

public class Utils {
    private static int numOfServers = 1;
    private static int numOfSelfCheckoutCounters = 0;
    private static int maxQueueLength = 1;
    private static double restProbability = 0.0;
    private static double greedyProbability = 0.0;

    /** 
     * empty constructed funcion.
     */
    public Utils() {}

    
    /** 
     * set server number.
     * 
     * @param numOfServers  server number
     */
    public void setNumOfServers(int numOfServers) {
        Utils.numOfServers = numOfServers;
    }

    
    /** 
     * get server number.
     * 
     * @return int
     */
    public int getNumOfServers() {
        return numOfServers;
    }

    
    /** 
     * set self-check counter number.
     * 
     * @param numOfSelfCheckoutCounters self-check counter number
     */
    public void setNumOfSelfCheckoutCounters(int numOfSelfCheckoutCounters) {
        Utils.numOfSelfCheckoutCounters = numOfSelfCheckoutCounters;
    }

    
    /** 
     * get self-check counter number.
     * 
     * @return int
     */
    public int getNumOfSelfCheckoutCounters() {
        return numOfSelfCheckoutCounters;
    }

    
    /** 
     * set max queue length.
     * 
     * @param maxQueueLength    max queue length
     */
    public void setMaxQueueLength(int maxQueueLength) {
        Utils.maxQueueLength = maxQueueLength;
    }

    
    /** 
     * get max queue length.
     * 
     * @return int
     */
    public int getMaxQueueLength() {
        return maxQueueLength;
    }

    
    /** 
     * set rest probability.
     * 
     * @param restProbability   rest probability
     */
    public void setRestProbability(double restProbability) {
        Utils.restProbability = restProbability;
    }

    
    /** 
     * get rest probability.
     * 
     * @return double
     */
    public double getRestProbability() {
        return restProbability;
    }

    
    /** 
     * set customer greedy probability.
     * 
     * @param greedyProbability customer greedy probability
     */
    public void setGreedyProbability(double greedyProbability) {
        Utils.greedyProbability = greedyProbability;
    }

    
    /** 
     * get customer greedy probability.
     * 
     * @return double
     */
    public double getGreedyProbability() {
        return greedyProbability;
    }

    
    /** 
     * get max method.
     * 
     * @param a parameter a
     * @param b parameter b
     * @return int
     */
    public int max(int a, int b) {
        return a > b ? a : b;
    }

}
