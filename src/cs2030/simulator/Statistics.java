package cs2030.simulator;

public class Statistics {
    private static double totalWaitingTime = 0;
    private static int numOfServedCustomers = 0;
    private static int numOfCustomers = 0;

    public static void setNumOfCustomers(int _numOfCustomers) {
        numOfCustomers = _numOfCustomers;
    }

    public static void addWaitingTime(double t) {
        totalWaitingTime += t;
    }

    public static void addServedCustomers() {
        numOfServedCustomers++;
    }

    public static double getTotalWaitingTime() {
        return totalWaitingTime;
    }

    public static double getAverageWaitingTime() {
        return totalWaitingTime / (double)numOfServedCustomers;
    }

    public static int getServedCustomers() {
        return numOfServedCustomers;
    }

    public static int getLeftCustomers() {
        return numOfCustomers - numOfServedCustomers;
    }

}
