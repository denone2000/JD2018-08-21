package by.it.nesterovich.jd02_01;

class Dispatcher {

    static final int RATE_OF_EXECUTION_SPEED = 100000;
    private static volatile int buyersInMarket = 0;

    static void addBuyer() {
        buyersInMarket++;
    }

    static void removeBuyer() {
        buyersInMarket--;
    }

    static int getBuyersInMarket() {
        return buyersInMarket;
    }
}
