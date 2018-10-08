package by.it.voinilo.jd02.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int KSPEED = 100;

    private static AtomicInteger buyesInMarket=new AtomicInteger(0);
    private static AtomicInteger factCount=new AtomicInteger(0);
    private static final int PLAN_COUNT = 100;

    static void addBuyer() {
        buyesInMarket.incrementAndGet();
    }

    static void buyerLeaveMarket() {
        buyesInMarket.decrementAndGet();
        factCount.incrementAndGet();
    }

    static int getBuyesInMarket() {
        return buyesInMarket.get();
    }

    static boolean marketIsOpened() {
        return (buyesInMarket.get() + factCount.get()) < PLAN_COUNT;
    }

    static boolean planComplete() {
        return factCount.get() >= PLAN_COUNT;
    }


}
