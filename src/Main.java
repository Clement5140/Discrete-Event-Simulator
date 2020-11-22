import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.List;

import cs2030.simulator.Pair;
import cs2030.simulator.Utils;
import cs2030.simulator.RandomGen;
import cs2030.simulator.Statistics;
import cs2030.simulator.Customer;
import cs2030.simulator.Shop;
import cs2030.simulator.Event;
import cs2030.simulator.ArriveEvent;
import cs2030.simulator.ServeEvent;
import cs2030.simulator.ServeEvent2;
import cs2030.simulator.Server;

public class Main {
    public static void main(String[] args) {
        // test();
        int randomGeneratorSeed = 0;
        int numOfServers = 1;
        int maxQueueLength = 1;
        int numOfCustomers = 0;
        double lambda = 0.0;
        double mu = 0.0;
        double rho = 0.0;
        double restProbability = 0.0;

        if (args.length == 5) {
            randomGeneratorSeed = Integer.valueOf(args[0]).intValue();
            numOfServers = Integer.valueOf(args[1]).intValue();
            maxQueueLength = 1;
            numOfCustomers = Integer.valueOf(args[2]).intValue();
            lambda = Double.valueOf(args[3]).doubleValue();
            mu = Double.valueOf(args[4]).doubleValue();
        }
        if (args.length == 6) {
            randomGeneratorSeed = Integer.valueOf(args[0]).intValue();
            numOfServers = Integer.valueOf(args[1]).intValue();
            maxQueueLength = Integer.valueOf(args[2]).intValue();
            numOfCustomers = Integer.valueOf(args[3]).intValue();
            lambda = Double.valueOf(args[4]).doubleValue();
            mu = Double.valueOf(args[5]).doubleValue();
        }
        if (args.length == 8) {
            randomGeneratorSeed = Integer.valueOf(args[0]).intValue();
            numOfServers = Integer.valueOf(args[1]).intValue();
            maxQueueLength = Integer.valueOf(args[2]).intValue();
            numOfCustomers = Integer.valueOf(args[3]).intValue();
            lambda = Double.valueOf(args[4]).doubleValue();
            mu = Double.valueOf(args[5]).doubleValue();
            rho = Double.valueOf(args[6]).doubleValue();
            restProbability = Double.valueOf(args[7]).doubleValue();
        }

        Statistics.setNumOfCustomers(numOfCustomers);
        Utils utils = new Utils();
        utils.setNumOfServers(numOfServers);
        utils.setMaxQueueLength(maxQueueLength);
        utils.setRestProbability(restProbability);
        RandomGen random = new RandomGen(randomGeneratorSeed, lambda, mu, rho);

        PriorityQueue<Event> pq = new PriorityQueue<Event>(new Comparator<Event>() {
            public int compare(Event o1, Event o2) {
                return o1.compareTo(o2);
            }
        });

        Shop shop = new Shop(numOfServers);

        int indexOfCustomers = 1;
        double arrivalTime = 0.0;
        for (int i = 0; i < numOfCustomers; ++i) {
            Customer customer = new Customer(indexOfCustomers++, arrivalTime);
            pq.add((Event)(new ArriveEvent(customer)));
            arrivalTime += random.genInterArrivalTime();
        }

        while (!pq.isEmpty()) {
            Event e = pq.poll();
            if (e.isVisible())
                System.out.println(e);
            Pair<Shop, Event> pair = e.execute(shop);
            if (pair.second() != null)
            {
                Event event = pair.second();
                if(event instanceof ServeEvent2)
                    event = new ServeEvent(event.getCustomer(), event.getEventStartTime(), 
                            Integer.valueOf(((ServeEvent2) event).toString()).intValue());
                pq.add(event);
            }
            shop = pair.first();
            // System.out.println(shop);
        }

        System.out.println("[" + String.format("%.3f", Statistics.getAverageWaitingTime()) + " " + Statistics.getServedCustomers() + " " + Statistics.getLeftCustomers() + "]");
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
