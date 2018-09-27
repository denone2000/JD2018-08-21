package by.it.korolchuk.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        int counterBuyer = 0;

        while (Dispatcher.marketIsOpened())
            for (int i = 0; i < Util.random(2) ; i++) {
            Buyer buyer = new Buyer(++counterBuyer);
           // buyers.add(buyer);
            buyer.start();
                System.out.println();

            }

        for (int currentSecond = 0; currentSecond < 120; currentSecond++) {
            for (int i = 0; i < Util.random(2); i++) {
                Buyer buyer = new Buyer(++counterBuyer);
                buyer.start();
                System.out.println("Всего в магазине " + Dispatcher.getBuyersInMarket());
                Util.sleep(1000);
            }
        }

        List<Thread> buyers = new ArrayList<>();
        for (Thread buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Всего в магазине:" + Dispatcher.getBuyersInMarket());
        System.out.println("Магазин закрыт");

        //Thread thread = new Thread(new Cashier());
        //thread.start();
    }
}
