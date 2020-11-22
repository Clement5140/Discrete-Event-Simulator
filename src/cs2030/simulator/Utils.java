package cs2030.simulator;

public class Utils {
    private static int numOfServers = 1;
    private static int numOfSelfCheckoutCounters = 0;
    private static int maxQueueLength = 1;
    private static double restProbability = 0.0;

    public Utils() {}

    public void setNumOfServers(int numOfServers) {
        Utils.numOfServers = numOfServers;
    }

    public int getNumOfServers() {
        return numOfServers;
    }

    public void setNumOfSelfCheckoutCounters(int numOfSelfCheckoutCounters) {
        Utils.numOfSelfCheckoutCounters = numOfSelfCheckoutCounters;
    }

    public int getNumOfSelfCheckoutCounters() {
        return numOfSelfCheckoutCounters;
    }

    public void setMaxQueueLength(int maxQueueLength) {
        Utils.maxQueueLength = maxQueueLength;
    }

    public int getMaxQueueLength() {
        return maxQueueLength;
    }

    public void setRestProbability(double restProbability) {
        Utils.restProbability = restProbability;
    }

    public double getRestProbability() {
        return restProbability;
    }

    public int max(int a, int b) {
        return a > b ? a : b;
    }

}
