package by.it.bindyuk.jd02_01;

class Dispatcher {


    static final int KOEFSPEED = 100;
    static private int buyersInMarket = 0;

    static void addBuyer() {
        buyersInMarket++;
    }

    static void subBuyer() {
        buyersInMarket--;
    }

    static int getBuyersInMarket() {
        return buyersInMarket;
    }

}
