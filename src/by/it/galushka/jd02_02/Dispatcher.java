package by.it.galushka.jd02_02;

public class Dispatcher {

    private static int buyersInMarket = 0;

    static void buyerEnterToMarket() {
        buyersInMarket++;
    }

    static void buyerLeaveMarket() {
        buyersInMarket--;
    }

    static int getBuyersInMarket() {
        return buyersInMarket;
    }
}
