package by.it.korolchuk.jd02_02;

class Dispatcher {
    static final int KoefSpeed = 100;
    private static volatile int buyersInMarket = 0;
    private static volatile int factCount = 0;
    private static final int planCount = 100;

    static synchronized void addBuyer() {

        buyersInMarket++;
    }

    static synchronized void buyerLeftMarket() {
        buyersInMarket--;
        factCount++;
    }

   static synchronized int getBuyersInMarket() {

        return buyersInMarket;
    }

    static synchronized boolean marketIsOpened() {

        return (buyersInMarket + factCount) < planCount;
    }

    static synchronized boolean completePlan() {

        return factCount >= planCount;
    }
}



