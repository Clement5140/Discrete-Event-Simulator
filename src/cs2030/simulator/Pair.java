package cs2030.simulator;

public class Pair<T, U> {
    private final T t;
    private final U u;

    public Pair(T t, U u) {
        this.t = t;
        this.u = u;
    }

    public T first() {
        return t;
    }

    public U second() {
        return u;
    }

    public static <A, B> Pair <A, B> of(A a, B b) {
        return new Pair <A, B> (a, b);
    }

}
