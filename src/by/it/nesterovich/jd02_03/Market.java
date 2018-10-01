package by.it.nesterovich.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    private static int counterBuyer = 0;
    private static int currentTime = 0;

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

        int buyersInMarket = Dispatcher.getBuyersInMarket();

        System.out.println("MAIN: магазин открыт ");

        ExecutorService executors = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            executors.execute(cashier);
        }

        while (Dispatcher.marketIsOpened()) {
            if (currentTime % 60 < 30 && buyersInMarket < currentTime % 60 + 10) {
                addBuyer();
            } else if (buyersInMarket <= 40 + (30 - (currentTime % 60))) {
                addBuyer();
            }
            Util.sleep(1000);
            System.out.println("Текучее время: >>>>..... " + currentTime + " .....<<<<\tMAIN: Всего в магазине: " + Dispatcher.getBuyersInMarket());
            currentTime++;
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executors.shutdown();
        while (!executors.isTerminated()) Util.sleep(100);
        System.out.println("MAIN: Всего в магазине: " + Dispatcher.getBuyersInMarket());
        System.out.println("MAIN: магазин закрыт");
    }

    private static void addBuyer() {
        for (int i = 0; i < Util.random(2); i++) {
            if (Dispatcher.marketIsOpened()) {
                Buyer buyer = new Buyer(++counterBuyer);
                Buyer.addBuyersToList(buyer);
                buyer.start();
                //System.out.println("Текучее время: >>>>..... " + currentTime + " .....<<<<\tMAIN: Всего в магазине: " + Dispatcher.getBuyersInMarket());
            }
        }
    }

}
