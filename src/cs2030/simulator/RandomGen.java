package cs2030.simulator;

public class RandomGen {
    private static RandomGenerator randomGenerator;

    /** 
     * 空构造函数.
     */
    public RandomGen() {}

    /** 
     * 构造函数.
     * 
     * @param seed  随机种子
     * @param lambda    lambda参数
     * @param mu    mu参数
     * @param rho   rho参数
     */
    public RandomGen(int seed, double lambda, double mu, double rho) {
        randomGenerator = new RandomGenerator(seed, lambda, mu, rho);
    }

    
    /** 
     * 随机客户到达时间.
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
     * 随机服务持续时间.
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
     * 随机server是否休息.
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
     * 随机休息时间.
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
     * 随机客户类型，是否贪心.
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
