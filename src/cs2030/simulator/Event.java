package cs2030.simulator;

import java.util.function.Function;

public abstract class Event {
    private final Customer customer;
    private final double eventStartTime;
    private final Function<Shop, Pair<Shop, Event>> func;
    private final Integer priority;
    private final boolean visible;

    /** 
     * constructed function.
     * 
     * @param customer  customer
     * @param eventStartTime    event start time
     * @param priority  priority
     * @param func  execute method
     */
    public Event(Customer customer, double eventStartTime,
        Integer priority, Function<Shop, Pair<Shop, Event>> func) {
        this.customer = customer;
        this.eventStartTime = eventStartTime;
        this.func = func;
        this.priority = priority;
        this.visible = true;
    }

    /** 
     * constructed function.
     * 
     * @param customer  customer
     * @param eventStartTime    event start time
     * @param priority  priority
     * @param func  execute method
     * @param visible   output or not
     */
    public Event(Customer customer, double eventStartTime,
        Integer priority, Function<Shop, Pair<Shop, Event>> func, boolean visible) {
        this.customer = customer;
        this.eventStartTime = eventStartTime;
        this.func = func;
        this.priority = priority;
        this.visible = visible;
    }

    
    /** 
     * get customer.
     * 
     * @return Customer
     */
    public Customer getCustomer() {
        return this.customer;
    }
    
    
    /** 
     * get event start time.
     * 
     * @return double
     */
    public double getEventStartTime() {
        return eventStartTime;
    }

    
    /** 
     * get output or not.
     * 
     * @return boolean
     */
    public boolean isVisible() {
        return visible;
    }

    
    /** 
     * sort comparator.
     * 
     * @param o comparison
     * @return int
     */
    public int compareTo(Event o) {
        int res = Double.compare(this.eventStartTime, o.getEventStartTime());
        if (res != 0) {
            return res;
        }
        return this.priority.compareTo(o.priority);
    }
    
    
    /** 
     * execute method.
     * 
     * @param shop  shop
     * @return Pair
     */
    public final Pair<Shop, Event> execute(Shop shop) {
        return this.func.apply(shop);
    }

}
