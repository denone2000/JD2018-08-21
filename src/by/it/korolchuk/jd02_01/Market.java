package by.it.korolchuk.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        int counterBuyer = 0;

        for (int currentSecond = 0; currentSecond < 120; currentSecond++) {
            for (int i = 0; i < Util.random(2); i++) {
                Buyer buyer = new Buyer(++counterBuyer);
                buyer.start();
                System.out.println("Всего в магазине " + Dispatcher.getBuyersInMarket());
                Util.sleep(1000);
            }
        }

        List<Buyer> buyers = new ArrayList<>();
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Всего в магазине:" + Dispatcher.getBuyersInMarket());
        System.out.println("Магазин закрыт");
    }
}
