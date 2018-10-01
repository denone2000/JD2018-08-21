package by.it.akhmelev.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        int counterBuyer = 0;

        System.out.println("MAIN: магазин открыт");
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            thread.start();
            threads.add(thread);
        }

        while (Dispatcher.marketIsOpened()) {
            for (int i = 0; i < Util.random(2); i++) {
                if (Dispatcher.marketIsOpened()) {
                    Buyer buyer = new Buyer(++counterBuyer);
                    threads.add(buyer);
                    buyer.start();
                    System.out.println("MAIN: Всего в магазине:" + Dispatcher.getBuyesInMarket());
                }
            }
            Util.sleep(1000);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("MAIN: Всего в магазине:" + Dispatcher.getBuyesInMarket());
        System.out.println("MAIN: магазин закрыт");

    }
}
