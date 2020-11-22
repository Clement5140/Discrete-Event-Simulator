package cs2030.simulator;

import java.util.LinkedList;
import java.util.Queue;

public class Server {
    private final int identifier;
    private final boolean isAvailable;
    private final boolean isResting;
    private final int numOfWaitingCustomer;
    private final double nextAvailableTime;
    private final Queue<Customer> customerQueue;

    public Server(int identifier, boolean isAvailable, boolean numOfWaitingCustomer, double nextAvailableTime) {
        this.identifier = identifier;
        this.isAvailable = isAvailable;
        this.isResting = false;
        this.numOfWaitingCustomer = numOfWaitingCustomer ? 1 : 0;
        this.nextAvailableTime = nextAvailableTime;
        this.customerQueue = new LinkedList<Customer>();
    }

    public Server(int identifier, boolean isAvailable, int numOfWaitingCustomer, double nextAvailableTime, Queue<Customer> customerQueue) {
        this.identifier = identifier;
        this.isAvailable = isAvailable;
        this.isResting = false;
        this.numOfWaitingCustomer = numOfWaitingCustomer;
        this.nextAvailableTime = nextAvailableTime;
        this.customerQueue = customerQueue;
    }

    public Server(int identifier, boolean isAvailable, boolean isResting, int numOfWaitingCustomer, double nextAvailableTime, Queue<Customer> customerQueue) {
        this.identifier = identifier;
        this.isAvailable = isAvailable;
        this.isResting = isResting;
        this.numOfWaitingCustomer = numOfWaitingCustomer;
        this.nextAvailableTime = nextAvailableTime;
        this.customerQueue = customerQueue;
    }

    public int getID(){
        return this.identifier;
    }
    public boolean isAvailable(){
        return this.isAvailable;
    }
    public boolean isResting(){
        return this.isResting;
    }
    public int getnumOfWaitingCustomer(){
        return this.numOfWaitingCustomer;
    }
    public double getNextAvailableTime(){
        return this.nextAvailableTime;
    }
    public Queue<Customer> getCustomerQueue() {
        return this.customerQueue;
    }
    public Customer getFirstCustomer() {
        return this.customerQueue.peek();
    }

    public Server pollFirstCustomer() {
        Queue<Customer> newCustomerQueue = new LinkedList<Customer>(customerQueue);
        newCustomerQueue.poll();
        return new Server(identifier, isAvailable, numOfWaitingCustomer, nextAvailableTime, newCustomerQueue);
    }
    public Server addCustomer(Customer customer) {
        Queue<Customer> newCustomerQueue = new LinkedList<Customer>(customerQueue);
        newCustomerQueue.add(customer);
        return new Server(identifier, isAvailable, numOfWaitingCustomer, nextAvailableTime, newCustomerQueue);
    }

    @Override
    public String toString(){
        Utils utils = new Utils();
        // System.out.println(this.numOfWaitingCustomer);
        if(this.isAvailable == true){
            return this.identifier + " is available";
        } else if(this.numOfWaitingCustomer < utils.getMaxQueueLength()) {
            return this.identifier + " is busy; available at " + String.format("%.3f", this.nextAvailableTime);
        } else {
            return this.identifier + " is busy; waiting customer to be served at " + String.format("%.3f",this.nextAvailableTime);
        }                  
    }

}
