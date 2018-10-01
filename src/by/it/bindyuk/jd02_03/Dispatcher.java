package by.it.bindyuk.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    static final int KOEFSPEED = 1;

    private static AtomicInteger factCount = new AtomicInteger(0);
    private static final int PLAN_COUNT = 100;


    static private AtomicInteger buyersInMarket = new AtomicInteger(0);

    static synchronized boolean isMarketOpen() {
        return (buyersInMarket.get() + factCount.get()) < PLAN_COUNT;
    }

    static synchronized boolean planComplete() {
        return factCount.get() >= PLAN_COUNT;
    }

    static synchronized void addBuyer() {
        buyersInMarket.incrementAndGet();
    }

    static synchronized void subBuyer() {
        buyersInMarket.decrementAndGet();
        factCount.incrementAndGet();
    }

    static synchronized int getBuyersInMarket() {
        return buyersInMarket.get();
    }

}
