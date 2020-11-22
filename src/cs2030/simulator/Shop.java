package cs2030.simulator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Shop {
    private final List<Server> serverList;

    /** 
     * empty constructed funcion.
     */
    public Shop() {
        serverList = new ArrayList<Server>();
    }

    /** 
     * constructed funcion.
     * 
     * @param numOfServers  server number
     */
    public Shop(int numOfServers) {
        int[] nums = IntStream.range(0, numOfServers).toArray();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        this.serverList = numList.stream()
            .map(i -> new Server(i + 1, true, false, 0)).collect(Collectors.toList());
    }

    /** 
     * constructed funcion.
     * 
     * @param serverList    server list
     */
    public Shop(List<Server> serverList) {
        this.serverList = new ArrayList<Server>(serverList);
    }

    /** 
     * constructed funcion.
     * 
     * @param numOfServers  server number
     * @param numOfSelfCheckoutCounters self-checkout counter number
     */
    public Shop(int numOfServers, int numOfSelfCheckoutCounters) {
        int[] nums = IntStream.range(0, numOfServers).toArray();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Server> serverList = numList.stream()
            .map(i -> new Server(i + 1, true, false, 0)).collect(Collectors.toList());
        nums = IntStream.range(numOfServers, numOfServers + numOfSelfCheckoutCounters).toArray();
        numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<Server> counterList = numList.stream()
            .map(i -> new Server(i + 1, true, true, 0, 0)).collect(Collectors.toList());
        // System.out.println(serverList.size() + " " + counterList.size());
        serverList.addAll(counterList);
        this.serverList = new ArrayList<Server>(serverList);
    }

    
    /** 
     * get server list.
     * 
     * @return List
     */
    public List<Server> getServerList() {
        return serverList;
    }

    
    /** 
     * get first server satisfying func.
     * 
     * @param func  execute method
     * @return Optional
     */
    public Optional<Server> find(Predicate<? super Server> func) {
        Stream<Server> serverStream = serverList.stream().filter(func);
        return serverStream.findFirst();
    }

    
    /** 
     * replace server and return a new Shop object.
     * 
     * @param s replacing server
     * @return Shop
     */
    public Shop replace(Server s) {
        Stream<Server> serverStream = serverList.stream().filter(x -> x.getID() == s.getID());
        Optional<Server> server = serverStream.findFirst();
        if (!server.isPresent()) {
            return new Shop(this.serverList);
        }
        List<Server> newServerList = new ArrayList<Server>(serverList);
        Collections.replaceAll(newServerList, server.get(), s);
        return new Shop(newServerList);
    }

    
    /** 
     * String transform.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return serverList.toString();
    }

}
