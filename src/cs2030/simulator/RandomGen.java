package cs2030.simulator;

public class RandomGen {
    private static RandomGenerator randomGenerator;

    /** 
     * empty constructed funcion.
     */
    public RandomGen() {}

    /** 
     * constructed funcion.
     * 
     * @param seed  random seed
     * @param lambda    lambda parameter
     * @param mu    mu parameter
     * @param rho   rho parameter
     */
    public RandomGen(int seed, double lambda, double mu, double rho) {
        randomGenerator = new RandomGenerator(seed, lambda, mu, rho);
    }

    
    /** 
     * random arrive time.
     * 
     * @return double
     */
    public double genInterArrivalTime() {
        if (randomGenerator == null) {
            return 1;
        }
        return randomGenerator.genInterArrivalTime();
    }

    
    /** 
     * random service time.
     * 
     * @return double
     */
    public double genServiceTime() {
        if (randomGenerator == null) {
            return 1;
        }
        return randomGenerator.genServiceTime();
    }

    
    /** 
     * rest or not.
     * 
     * @return double
     */
    public double genRandomRest() {
        if (randomGenerator == null) {
            return 1;
        }
        return randomGenerator.genRandomRest();
    }

    
    /** 
     * random rest time.
     * 
     * @return double
     */
    public double genRestPeriod() {
        if (randomGenerator == null) {
            return 1;
        }
        return randomGenerator.genRestPeriod();
    }

    
    /** 
     * random customer type.
     * 
     * @return double
     */
    public double genCustomerType() {
        if (randomGenerator == null) {
            return 1;
        }
        return randomGenerator.genCustomerType();
    }


}
