package by.it.korolchuk.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    static final int KoefSpeed = 100;
    private static AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static AtomicInteger factCount = new AtomicInteger(0);
    private static final int planCount = 100;

    static void addBuyer() {

        buyersInMarket.incrementAndGet();
    }

    static void buyerLeftMarket() {

        buyersInMarket.decrementAndGet();
        factCount.incrementAndGet();
    }

   static int getBuyersInMarket() {

        return buyersInMarket.get();
    }

    static boolean marketIsOpened() {

        return (buyersInMarket.get() + factCount.get()) < planCount;
    }

    static boolean completePlan() {

        return factCount.get() >= planCount;
    }
}



