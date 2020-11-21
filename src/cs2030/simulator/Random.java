package cs2030.simulator;

public class Random {
    private static RandomGenerator randomGenerator;

    public Random() {}

    public static void setRandom(int seed, double lambda, double mu, double rho) {
        randomGenerator = new RandomGenerator(seed, lambda, mu, rho);
    }

    public static double genInterArrivalTime() {
        return randomGenerator.genInterArrivalTime();
    }

    public static double genServiceTime() {
        return randomGenerator.genServiceTime();
    }

    public static double genRandomRest() {
        return randomGenerator.genRandomRest();
    }

    public static double genRestPeriod() {
        return randomGenerator.genRestPeriod();
    }

    public static double genCustomerType() {
        return randomGenerator.genCustomerType();
    }

}
