import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.List;
import java.util.ArrayList;
import cs2030.simulator.*;

class Main {
    public static void main(String[] args) {
        test();
        // Scanner sc = new Scanner(System.in);
        // PriorityQueue<Event> pq = new PriorityQueue<Event>();

        // int numOfServers = sc.nextInt();
        // List<Server> serverList = new ArrayList<>();
        // for (int i = 0; i < numOfServers; i++)
        //     serverList.add(new Server(i + 1, true, false, 0));
        // Shop shop = new Shop(serverList);

        // int indexOfCustomers = 0;
        // while (sc.hasNextDouble()) {
        //     double arrivalTime = sc.nextDouble();
        //     Customer customer = new Customer(indexOfCustomers++, arrivalTime);
        //     pq.add(new ArriveEvent(customer, arrivalTime));
        // }

        // while (!pq.isEmpty()) {
        //     Event e = pq.poll();
        //     System.out.println(e);
        //     Pair pair = e.execute(shop);
        //     if (pair.getEvent() != null)
        //         pq.add(pair.getEvent());
        //     shop = pair.getShop();
        // }

        // sc.close();
    }

    public static void test() {
        // test_level1();
        // test_level2();
    }

    // public static void test_level1() {
    //     System.out.println(new Shop(2));
    //     Shop shops = new Shop(List.of(new Server(1, true, false, 0), new Server(2, false, false, 1.0)));
    //     System.out.println(shops);
    //     System.out.println(shops.find(x -> x.isAvailable()));
    //     System.out.println(new Shop(2).find(x -> x.isAvailable()));
    //     shops.find(x -> x.isAvailable()).ifPresent(System.out::println);
    //     Server s = new Server(1, false, false, 2.0);
    //     System.out.println(shops.replace(s));
    //     System.out.println(shops.replace(s).find(x -> x.isAvailable()));
    //     System.out.println(shops);
    // }

    // public static void test_level2() {
    //     Pair<Integer, String> pair = Pair.of(1, "one");
    //     System.out.println(pair.first());
    //     System.out.println(pair.second());
    //     Pair<Long,Long> pair1 = Pair.of(0L, 100L);
    //     System.out.println(pair1.first());
    //     System.out.println(pair1.second());
    // }

}
