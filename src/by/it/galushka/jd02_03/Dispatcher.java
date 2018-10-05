package by.it.galushka.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    private static int xspeed = 1;

    static void setXspeed(int xspeed) {
        Dispatcher.xspeed = xspeed;
    }

    static int getXspeed() {
        return xspeed;
    }

    private static final int PLAN_COUNT = 100;
    private static AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static AtomicInteger goOutBuyers = new AtomicInteger(0);

    static void buyerEnterToMarket() {
        buyersInMarket.incrementAndGet();
    }

    static void buyerLeaveMarket() {
        buyersInMarket.decrementAndGet();
        goOutBuyers.incrementAndGet();
    }

    static int getBuyersInMarket() {
        return buyersInMarket.get();
    }

    static boolean marketIsOpened(){
        return (buyersInMarket.get() + goOutBuyers.get()) < PLAN_COUNT;
    }

    static boolean planCompleted(){
        return goOutBuyers.get() >= PLAN_COUNT;
    }
}
