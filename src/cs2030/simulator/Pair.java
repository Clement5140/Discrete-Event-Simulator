package cs2030.simulator;

public class Pair<T, U> {
    private final T t;
    private final U u;

    /** 
     * 构造函数.
     * 
     * @param t 第一个元素
     * @param u 第二个元素
     */
    public Pair(T t, U u) {
        this.t = t;
        this.u = u;
    }

    
    /** 
     * 第一个元素.
     * 
     * @return T
     */
    public T first() {
        return t;
    }

    
    /** 
     * 第二个元素.
     * 
     * @return U
     */
    public U second() {
        return u;
    }

    
    /** 
     * 新建Pair对象.
     * 
     * @param a 第一个元素
     * @param b 第二个元素
     * @return Pair
     */
    public static <A, B> Pair<A, B> of(A a, B b) {
        return new Pair<A, B>(a, b);
    }

}
