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
     * 空构造函数.
     */
    public Shop() {
        serverList = new ArrayList<Server>();
    }

    /** 
     * 构造函数.
     * 
     * @param numOfServers  server数目
     */
    public Shop(int numOfServers) {
        int[] nums = IntStream.range(0, numOfServers).toArray();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        this.serverList = numList.stream()
            .map(i -> new Server(i + 1, true, false, 0)).collect(Collectors.toList());
    }

    /** 
     * 构造函数.
     * 
     * @param serverList    server列表
     */
    public Shop(List<Server> serverList) {
        this.serverList = new ArrayList<Server>(serverList);
    }

    /** 
     * 构造函数.
     * 
     * @param numOfServers  server数目
     * @param numOfSelfCheckoutCounters self-checkout counter数目
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
     * 获取server列表.
     * 
     * @return List
     */
    public List<Server> getServerList() {
        return serverList;
    }

    
    /** 
     * 获取满足条件的第一个server.
     * 
     * @param func  execute的方法
     * @return Optional
     */
    public Optional<Server> find(Predicate<? super Server> func) {
        Stream<Server> serverStream = serverList.stream().filter(func);
        return serverStream.findFirst();
    }

    
    /** 
     * 替换相应server并返回新的Shop对象.
     * 
     * @param s 替换的server
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
     * String转换.
     * 
     * @return String
     */
    @Override
    public String toString() {
        return serverList.toString();
    }

}
