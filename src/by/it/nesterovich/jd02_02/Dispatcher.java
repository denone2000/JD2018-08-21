package by.it.nesterovich.jd02_02;

class Dispatcher {

    static final int RATE_OF_EXECUTION_SPEED = 100000;
    private static volatile int buyersInMarket = 0;
    private static volatile int factCount = 0;
    private static final int PLAN_COUNT = 100;

    static synchronized void addBuyer() {
        buyersInMarket++;
    }

    static synchronized int getBuyersInMarket() {
        return buyersInMarket;
    }

    static synchronized void buyerLeaveMarket() {
        buyersInMarket--;
        factCount++;
    }

    static synchronized boolean marketIsOpened() {
        return (buyersInMarket + factCount) < PLAN_COUNT;
    }

    static synchronized boolean planComplete() {
        return factCount >= PLAN_COUNT;
    }


}
