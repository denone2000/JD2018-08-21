package by.it.galushka.jd02_03;

public class Dispatcher {

    private static int xspeed = 1;

    static void setXspeed(int xspeed) {
        Dispatcher.xspeed = xspeed;
    }

    static int getXspeed() {
        return xspeed;
    }

    private static final int PLAN_COUNT = 100;
    private static int buyersInMarket = 0;
    private static int leftBuyers = 0;

    static synchronized void buyerEnterToMarket() {
        buyersInMarket++;
    }

    static synchronized void buyerLeaveMarket() {
        buyersInMarket--;
        leftBuyers++;
    }

    static synchronized int getBuyersInMarket() {
        return buyersInMarket;
    }

    static synchronized boolean marketIsOpened(){
        return (buyersInMarket + leftBuyers) < PLAN_COUNT;
    }

    static synchronized boolean planCompleted(){
        return leftBuyers >= PLAN_COUNT;
    }
}
