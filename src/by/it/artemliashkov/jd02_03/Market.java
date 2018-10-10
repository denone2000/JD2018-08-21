package by.it.artemliashkov.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private static List<Thread> threads = new ArrayList<>();
    public static void main(String args[])
    {
        int counterBuyer = 0;
        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            thread.start();
            threads.add(thread);
        }

        while (Discpathcer.marketIsOpened()) {
            for (int i = 0; i < Util.random(2); i++) {
                if (Discpathcer.marketIsOpened()) {
                    Buyer buyer = new Buyer(++counterBuyer);
                    threads.add(buyer);
                    buyer.start();
                    System.out.println("В магазине всего:" + Discpathcer.getBuyesInMarket());
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
        System.out.println("In market total:" + Discpathcer.getBuyesInMarket());
        System.out.println("Магазин закрыт");

    }



    static synchronized void openCashier(int number) {
        Cashier cashier = new Cashier(number);
        Thread thread = new Thread(cashier);
        thread.start();
        threads.add(thread);
    }



}
