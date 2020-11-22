package cs2030.simulator;

import java.util.function.Function;

public abstract class Event {
    private final Customer customer;
    private final double eventStartTime;
    private final Function<Shop, Pair<Shop, Event>> func;
    private final Integer priority;
    private final boolean visible;

    /** 
     * 构造函数.
     * 
     * @param customer  客户
     * @param eventStartTime    开始时间
     * @param priority  优先级
     * @param func  execute方法
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
     * 构造函数.
     * 
     * @param customer  客户
     * @param eventStartTime    开始时间
     * @param priority  优先级
     * @param func  execute方法
     * @param visible   是否打印
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
     * 获取客户.
     * 
     * @return Customer
     */
    public Customer getCustomer() {
        return this.customer;
    }
    
    
    /** 
     * 获取事件开始时间.
     * 
     * @return double
     */
    public double getEventStartTime() {
        return eventStartTime;
    }

    
    /** 
     * 是否打印该事件.
     * 
     * @return boolean
     */
    public boolean isVisible() {
        return visible;
    }

    
    /** 
     * 排序比较函数.
     * 
     * @param o 比较对象
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
     * 执行事件方法.
     * 
     * @param shop  商店
     * @return Pair
     */
    public final Pair<Shop, Event> execute(Shop shop) {
        return this.func.apply(shop);
    }

}
