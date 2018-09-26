package by.it.korolchuk.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        int counterBuyer = 0;
        List<Buyer> buyers = new ArrayList<>();

        for (int currentSecond = 0; currentSecond < Util.random(2); currentSecond++) {
            Buyer buyer = new Buyer(++counterBuyer);
            buyer.start();
           System.out.println("Всего в магазине " + Dispatcher.getBuyersInMarket());
            Util.sleep(1000);
            try {
                Thread.sleep(1000/Dispatcher.KoefSpeed);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Buyer buyer1 = new Buyer(1);
        Buyer buyer2 = new Buyer(2);
        buyer1.start();
        buyer2.start();
    }
}
