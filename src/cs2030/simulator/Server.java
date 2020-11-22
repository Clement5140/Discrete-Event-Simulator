package cs2030.simulator;

import java.util.LinkedList;
import java.util.Queue;

public class Server {
    private final int identifier;
    private final boolean isAvailable;
    private final boolean isResting;
    private final boolean isCounter;
    private final int numOfWaitingCustomer;
    private final double nextAvailableTime;
    private final Queue<Customer> customerQueue;
    private static int numOfSharingCustomer = 0;
    private static Queue<Customer> sharingCustomerQueue = new LinkedList<Customer>();

    /** 
     * 构造函数.
     * 
     * @param identifier    ID
     * @param isAvailable   是否空闲
     * @param numOfWaitingCustomer  等待队列长度
     * @param nextAvailableTime 下次空闲时间
     */
    public Server(int identifier, boolean isAvailable,
        boolean numOfWaitingCustomer, double nextAvailableTime) {
        this.identifier = identifier;
        this.isAvailable = isAvailable;
        this.isResting = false;
        this.isCounter = false;
        this.numOfWaitingCustomer = numOfWaitingCustomer ? 1 : 0;
        this.nextAvailableTime = nextAvailableTime;
        this.customerQueue = new LinkedList<Customer>();
    }

    /** 
     * 构造函数.
     * 
     * @param identifier    ID
     * @param isAvailable   是否空闲
     * @param numOfWaitingCustomer  等待队列长度
     * @param nextAvailableTime 下次空闲时间
     * @param customerQueue 客户队列
     */
    public Server(int identifier, boolean isAvailable,
        int numOfWaitingCustomer, double nextAvailableTime, Queue<Customer> customerQueue) {
        this.identifier = identifier;
        this.isAvailable = isAvailable;
        this.isResting = false;
        this.isCounter = false;
        this.numOfWaitingCustomer = numOfWaitingCustomer;
        this.nextAvailableTime = nextAvailableTime;
        this.customerQueue = customerQueue;
    }

    /** 
     * 构造函数.
     * 
     * @param identifier    ID
     * @param isAvailable   是否空闲
     * @param isCounter     是否是self-checkout counter
     * @param numOfWaitingCustomer  等待队列长度
     * @param nextAvailableTime 下次空闲时间
     */
    public Server(int identifier, boolean isAvailable,
        boolean isCounter, int numOfWaitingCustomer, double nextAvailableTime) {
        this.identifier = identifier;
        this.isAvailable = isAvailable;
        this.isResting = false;
        this.isCounter = isCounter;
        this.numOfWaitingCustomer = numOfWaitingCustomer;
        this.nextAvailableTime = nextAvailableTime;
        this.customerQueue = new LinkedList<Customer>();
    }

    /** 
     * 构造函数.
     * 
     * @param identifier    ID
     * @param isAvailable   是否空闲
     * @param isResting     是否在rest
     * @param numOfWaitingCustomer  等待队列长度
     * @param nextAvailableTime 下次空闲时间
     * @param customerQueue 客户队列
     */
    public Server(int identifier, boolean isAvailable, boolean isResting,
        int numOfWaitingCustomer, double nextAvailableTime, Queue<Customer> customerQueue) {
        this.identifier = identifier;
        this.isAvailable = isAvailable;
        this.isResting = isResting;
        this.isCounter = false;
        this.numOfWaitingCustomer = numOfWaitingCustomer;
        this.nextAvailableTime = nextAvailableTime;
        this.customerQueue = customerQueue;
    }

    
    /** 
     * 获取server的ID.
     * 
     * @return int
     */
    public int getID() {
        return this.identifier;
    }

    
    /** 
     * 是否空闲.
     * 
     * @return boolean
     */
    public boolean isAvailable() {
        return this.isAvailable;
    }

    
    /** 
     * 是否在rest.
     * 
     * @return boolean
     */
    public boolean isResting() {
        return this.isResting;
    }

    
    /** 
     * 是否为self-check counter.
     * 
     * @return boolean
     */
    public boolean isCounter() {
        return this.isCounter;
    }

    
    /** 
     * 等待队列长度.
     * 
     * @return int
     */
    public int getnumOfWaitingCustomer() {
        return this.numOfWaitingCustomer;
    }

    
    /** 
     * 下一次空闲的时间.
     * 
     * @return double
     */
    public double getNextAvailableTime() {
        return this.nextAvailableTime;
    }

    
    /** 
     * 获取等待队列.
     * 
     * @return Queue
     */
    public Queue<Customer> getCustomerQueue() {
        return this.customerQueue;
    }

    
    /** 
     * 获取等待队列的队首客户.
     * 
     * @return Customer
     */
    public Customer getFirstCustomer() {
        return this.customerQueue.peek();
    }

    
    /** 
     * 获取等待队列的队首客户并弹出.
     * 
     * @return Server
     */
    public Server pollFirstCustomer() {
        Queue<Customer> newCustomerQueue = new LinkedList<Customer>(customerQueue);
        newCustomerQueue.poll();
        return new Server(identifier, isAvailable,
            numOfWaitingCustomer, nextAvailableTime, newCustomerQueue);
    }
    
    
    /** 
     * 将客户加入等待队列队尾.
     * 
     * @param customer  客户
     * @return Server
     */
    public Server addCustomer(Customer customer) {
        Queue<Customer> newCustomerQueue = new LinkedList<Customer>(customerQueue);
        newCustomerQueue.add(customer);
        return new Server(identifier, isAvailable,
            numOfWaitingCustomer, nextAvailableTime, newCustomerQueue);
    }

    
    /** 
     * 共享等待队列长度.
     * 
     * @return int
     */
    public int getNumOfSharingCustomer() {
        return Server.numOfSharingCustomer;
    }

    
    /** 
     * 获取共享等待队列的队首客户.
     * 
     * @return Customer
     */
    public Customer getFirstSharingCustomer() {
        return Server.sharingCustomerQueue.peek();
    }

    
    /** 
     * 获取共享等待队列的队首客户并弹出.
     * 
     * @return Customer
     */
    public Customer pollFirstSharingCustomer() {
        Server.numOfSharingCustomer--;
        // System.out.println("poll " + Server.numOfSharingCustomer);
        return Server.sharingCustomerQueue.poll();
    }

    
    /** 
     * 将客户加入共享等待队列的队尾.
     * 
     * @param customer  客户
     */
    public void addSharingCustomer(Customer customer) {
        Server.numOfSharingCustomer++;
        // System.out.println("add " + Server.numOfSharingCustomer);
        Server.sharingCustomerQueue.add(customer);
    }

    
    /** 
     * String转换.
     * 
     * @return String
     */
    @Override
    public String toString() {
        Utils utils = new Utils();
        // System.out.println(this.numOfWaitingCustomer);
        if (this.isAvailable == true) {
            return this.identifier + " is available";
        } else if (this.numOfWaitingCustomer < utils.getMaxQueueLength()) {
            return this.identifier + " is busy; available at "
                + String.format("%.3f", this.nextAvailableTime);
        } else {
            return this.identifier + " is busy; waiting customer to be served at "
                + String.format("%.3f",this.nextAvailableTime);
        }                  
    }

}
