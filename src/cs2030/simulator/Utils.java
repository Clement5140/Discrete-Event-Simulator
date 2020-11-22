package cs2030.simulator;

public class Utils {
    private static int maxQueueLength = 1;
    private static double restProbability = 0.0;

    public Utils() {}

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
