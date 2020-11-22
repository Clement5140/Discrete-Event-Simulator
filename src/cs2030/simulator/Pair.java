package cs2030.simulator;

public class Pair<T, U> {
    private final T t;
    private final U u;

    /** 
     * constructed funcion.
     * 
     * @param t first element
     * @param u second element
     */
    public Pair(T t, U u) {
        this.t = t;
        this.u = u;
    }

    
    /** 
     * first element.
     * 
     * @return T
     */
    public T first() {
        return t;
    }

    
    /** 
     * second element.
     * 
     * @return U
     */
    public U second() {
        return u;
    }

    
    /** 
     * new Pair object.
     * 
     * @param a first element
     * @param b second element
     * @return Pair
     */
    public static <A, B> Pair<A, B> of(A a, B b) {
        return new Pair<A, B>(a, b);
    }

}
