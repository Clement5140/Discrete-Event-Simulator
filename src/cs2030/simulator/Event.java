package cs2030.simulator;

import java.util.function.Function;

public abstract class Event{
    private final Customer customer;
    private final double eventStartTime;
    private final Function<Shop, Pair<Shop, Event>> func;
    private final Integer priority;

    public Event(Customer customer, double eventStartTime, Integer priority, Function<Shop, Pair<Shop, Event>> func){
        this.customer = customer;
        this.eventStartTime = eventStartTime;
        this.func = func;
        this.priority = priority;
    }

    public Customer getCustomer() {
        return this.customer;
    }
    
    public double getEventStartTime() {
        return eventStartTime;
    }

    public int compareTo(Event o) {
        int res = Double.compare(this.eventStartTime, o.getEventStartTime());
        if(res != 0) return res;
        return this.priority.compareTo(o.priority);
    }
    
    public final Pair<Shop, Event> execute(Shop shop) {
        return this.func.apply(shop);
    }

}
