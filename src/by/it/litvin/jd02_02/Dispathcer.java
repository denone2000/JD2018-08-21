package by.it.litvin.jd02_02;

class Dispathcer {

    static final int KSPEED = 100;

    private static volatile int buyesInMarket = 0;
    private static volatile int factCount = 0;
    private static final int PLAN_COUNT = 100;

    static synchronized void addBuyer() {
        buyesInMarket++;
    }

    static synchronized void buyerLeaveMarket() {
        buyesInMarket--;
        factCount++;
    }

    static synchronized int getBuyesInMarket() {
        return buyesInMarket;
    }

    static synchronized boolean marketIsOpened() {
        return (buyesInMarket + factCount) < PLAN_COUNT;
    }

    static synchronized boolean planComplete() {
        return factCount >= PLAN_COUNT;
    }


}
