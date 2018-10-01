package by.it.bindyuk.jd02_02;

class Dispatcher {
    static final int KOEFSPEED = 100;

    private static volatile int factCount = 0;
    private static final int PLAN_COUNT = 100;


    static private int buyersInMarket = 0;

    static synchronized boolean isMarketOpen() {
        return (buyersInMarket + factCount) < PLAN_COUNT;
    }

    static synchronized boolean planComplete() {
        return factCount >= PLAN_COUNT;
    }

    static synchronized void addBuyer() {
        buyersInMarket++;
    }

    static synchronized void subBuyer() {
        buyersInMarket--;
        factCount++;
    }

    static synchronized int getBuyersInMarket() {
        return buyersInMarket;
    }

}
