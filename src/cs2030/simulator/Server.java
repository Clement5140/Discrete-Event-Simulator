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
     * constructed funcion.
     * 
     * @param identifier    ID
     * @param isAvailable   available or not
     * @param numOfWaitingCustomer  number of waiting custormer
     * @param nextAvailableTime next available time
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
     * constructed funcion.
     * 
     * @param identifier    ID
     * @param isAvailable   available or not
     * @param numOfWaitingCustomer  number of waiting custormer
     * @param nextAvailableTime next available time
     * @param customerQueue custormer queue
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
     * constructed funcion.
     * 
     * @param identifier    ID
     * @param isAvailable   available or not
     * @param isCounter     is self-checkout counter or not
     * @param numOfWaitingCustomer  number of waiting custormer
     * @param nextAvailableTime next available time
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
     * constructed funcion.
     * 
     * @param identifier    ID
     * @param isAvailable   available or not
     * @param isResting     resting or not
     * @param numOfWaitingCustomer  number of waiting custormer
     * @param nextAvailableTime next available time
     * @param customerQueue custormer queue
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
     * get server identifier.
     * 
     * @return int
     */
    public int getID() {
        return this.identifier;
    }

    
    /** 
     * get available or not.
     * 
     * @return boolean
     */
    public boolean isAvailable() {
        return this.isAvailable;
    }

    
    /** 
     * get resting or not.
     * 
     * @return boolean
     */
    public boolean isResting() {
        return this.isResting;
    }

    
    /** 
     * get is self-check counter or not.
     * 
     * @return boolean
     */
    public boolean isCounter() {
        return this.isCounter;
    }

    
    /** 
     * get waiting customer number.
     * 
     * @return int
     */
    public int getnumOfWaitingCustomer() {
        return this.numOfWaitingCustomer;
    }

    
    /** 
     * get next available time.
     * 
     * @return double
     */
    public double getNextAvailableTime() {
        return this.nextAvailableTime;
    }

    
    /** 
     * get waiting queue.
     * 
     * @return Queue
     */
    public Queue<Customer> getCustomerQueue() {
        return this.customerQueue;
    }

    
    /** 
     * get first customer in waiting queue.
     * 
     * @return Customer
     */
    public Customer getFirstCustomer() {
        return this.customerQueue.peek();
    }

    
    /** 
     * get first customer in waiting queue and pop out.
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
     * put a new customer in waiting queue.
     * 
     * @param customer  customer
     * @return Server
     */
    public Server addCustomer(Customer customer) {
        Queue<Customer> newCustomerQueue = new LinkedList<Customer>(customerQueue);
        newCustomerQueue.add(customer);
        return new Server(identifier, isAvailable,
            numOfWaitingCustomer, nextAvailableTime, newCustomerQueue);
    }

    
    /** 
     * sharing customer queue number.
     * 
     * @return int
     */
    public int getNumOfSharingCustomer() {
        return Server.numOfSharingCustomer;
    }

    
    /** 
     * get first customer in sharing queue.
     * 
     * @return Customer
     */
    public Customer getFirstSharingCustomer() {
        return Server.sharingCustomerQueue.peek();
    }

    
    /** 
     * get first customer in sharing queue and pop out.
     * 
     * @return Customer
     */
    public Customer pollFirstSharingCustomer() {
        Server.numOfSharingCustomer--;
        // System.out.println("poll " + Server.numOfSharingCustomer);
        return Server.sharingCustomerQueue.poll();
    }

    
    /** 
     * put a new customer in sharing queue.
     * 
     * @param customer  customer
     */
    public void addSharingCustomer(Customer customer) {
        Server.numOfSharingCustomer++;
        // System.out.println("add " + Server.numOfSharingCustomer);
        Server.sharingCustomerQueue.add(customer);
    }

    
    /** 
     * String transform.
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
