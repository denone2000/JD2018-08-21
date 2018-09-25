package by.it.akhmelev.jd02_01;

class Dispathcer {
    static final int KSPEED = 100;

    private static volatile int buyesInMarket = 0;

    static void addBuyer() {
        buyesInMarket++;
    }

    static void removeBuyer() {
        buyesInMarket--;
    }

    static int getBuyesInMarket() {
        return buyesInMarket;
    }


}
