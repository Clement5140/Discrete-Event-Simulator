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

    public Shop() { serverList = new ArrayList<Server>(); }

    public Shop(int numOfServers) {
        int[] nums = IntStream.range(0, numOfServers).toArray();
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        this.serverList = numList.stream().map(i -> new Server(i + 1, true, false, 0)).collect(Collectors.toList());
    }

    public Shop(List<Server> serverList) {
        this.serverList = new ArrayList<Server>(serverList);
    }

    public List<Server> getServerList() {
        return serverList;
    }

    public Optional<Server> find(Predicate<? super Server> func) {
        Stream<Server> serverStream = serverList.stream().filter(func);
        return serverStream.findFirst();
    }

    public Shop replace(Server s) {
        Stream<Server> serverStream = serverList.stream().filter(x->x.getID() == s.getID());
        Optional<Server> server = serverStream.findFirst();
        if(!server.isPresent()) return new Shop(this.serverList);
        List<Server> newServerList = new ArrayList<Server>(serverList);
        Collections.replaceAll(newServerList, server.get(), s);
        return new Shop(newServerList);
    }

    @Override
    public String toString(){
        return serverList.toString();
    }

}
