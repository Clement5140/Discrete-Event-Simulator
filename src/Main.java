import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

import cs2030.simulator.*;

class Main {
    public static void main(String[] args) {
        // test();
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Event> pq = new PriorityQueue<Event>(new Comparator<Event>() {
            public int compare(Event o1, Event o2) {
                return o1.compareTo(o2);
            }
        });

        int numOfServers = sc.nextInt();
        List<Server> serverList = new ArrayList<>();
        for (int i = 0; i < numOfServers; i++)
            serverList.add(new Server(i + 1, true, false, 0));
        Shop shop = new Shop(serverList);

        int indexOfCustomers = 1;
        while (sc.hasNextDouble()) {
            double arrivalTime = sc.nextDouble();
            Customer customer = new Customer(indexOfCustomers++, arrivalTime);
            pq.add((Event)(new ArriveEvent(customer)));
        }

        while (!pq.isEmpty()) {
            Event e = pq.poll();
            System.out.println(e);
            Pair<Shop, Event> pair = e.execute(shop);
            if (pair.second() != null)
                pq.add(pair.second());
            shop = pair.first();
            // System.out.println(shop);
        }

        sc.close();
    }

    public static void test() {
        test_level1();
        test_level2();
    }

    public static void test_level1() {
        System.out.println(new Shop(2));
        Shop shops = new Shop(List.of(new Server(1, true, false, 0), new Server(2, false, false, 1.0)));
        System.out.println(shops);
        System.out.println(shops.find(x -> x.isAvailable()));
        System.out.println(new Shop(2).find(x -> x.isAvailable()));
        shops.find(x -> x.isAvailable()).ifPresent(System.out::println);
        Server s = new Server(1, false, false, 2.0);
        System.out.println(shops.replace(s));
        System.out.println(shops.replace(s).find(x -> x.isAvailable()));
        System.out.println(shops);
    }

    public static void test_level2() {
        Pair<Integer, String> pair = Pair.of(1, "one");
        System.out.println(pair.first());
        System.out.println(pair.second());
        Pair<Long,Long> pair1 = Pair.of(0L, 100L);
        System.out.println(pair1.first());
        System.out.println(pair1.second());

        System.out.println();

        System.out.println(new ArriveEvent(new Customer(1, 1.0)).execute(new Shop(List.of(new Server(1,true,false,0)))).first());
        System.out.println(new ArriveEvent(new Customer(1, 1.0)).execute(new Shop(List.of(new Server(1,true,false,0)))).second());
        System.out.println(new ArriveEvent(new Customer(1, 1.0)).execute(new Shop(List.of(new Server(1,false,false,1.0)))).first());
        System.out.println(new ArriveEvent(new Customer(1, 1.0)).execute(new Shop(List.of(new Server(1,false,false,1.0)))).second());
        System.out.println(new ArriveEvent(new Customer(1, 1.0)).execute(new Shop(List.of(new Server(1,false,true,2.0)))).first());
        System.out.println(new ArriveEvent(new Customer(1, 1.0)).execute(new Shop(List.of(new Server(1,false,true,2.0)))).second());
    }

}
