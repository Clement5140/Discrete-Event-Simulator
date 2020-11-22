package cs2030.simulator;

public class RandomGen {
    private static RandomGenerator randomGenerator;

    public RandomGen() {}

    public RandomGen(int seed, double lambda, double mu, double rho) {
        randomGenerator = new RandomGenerator(seed, lambda, mu, rho);
    }

    public double genInterArrivalTime() {
        if (randomGenerator == null) return 1;
        return randomGenerator.genInterArrivalTime();
    }

    public double genServiceTime() {
        if (randomGenerator == null) return 1;
        return randomGenerator.genServiceTime();
    }

    public double genRandomRest() {
        if (randomGenerator == null) return 1;
        return randomGenerator.genRandomRest();
    }

    public double genRestPeriod() {
        if (randomGenerator == null) return 1;
        return randomGenerator.genRestPeriod();
    }

    public double genCustomerType() {
        if (randomGenerator == null) return 1;
        return randomGenerator.genCustomerType();
    }


}
