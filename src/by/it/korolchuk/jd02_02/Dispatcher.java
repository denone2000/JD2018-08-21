package by.it.korolchuk.jd02_02;

class Dispatcher {
    static final int KoefSpeed = 10;
    private static int buyersInMarket = 0;
    private static volatile int buyerInMarket = 0;
    private static volatile int factCount = 0;
    private static final int planCount = 100;

    static void addBuyer() {

        buyersInMarket++;
    }

    static void buyerLeftMarket() {
        buyersInMarket--;
        factCount++;
    }

    static int getBuyersInMarket() {
        return buyersInMarket;
    }

    static boolean marketIsOpened() {
        return (buyerInMarket + factCount) < planCount;
    }

static boolean completePlan() {
    return (buyerInMarket + factCount) > planCount;
}
}



