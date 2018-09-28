package by.it.korolchuk.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {

        int counterBuyer = 0;
        List<Thread> threads = new ArrayList<>();

        while (Dispatcher.marketIsOpened()) {
            for (int i = 0; i < Util.random(2); i++) {
                if (Dispatcher.marketIsOpened()) {
                    Buyer buyer = new Buyer(++counterBuyer);
                    threads.add(buyer);
                    buyer.start();
                    System.out.println("Всего в магазине" + Dispatcher.getBuyersInMarket());
                }
            }
            Util.sleep(1000);
        }

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            thread.start();
            threads.add(thread);
        }


        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Всего в магазине:" + Dispatcher.getBuyersInMarket());
        System.out.println("Магазин закрыт");
    }
}
