package by.it.yaroshchuk.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    private static List<Thread> threads = new ArrayList<>();
    private static int counterBuyer = 0;
    private static int counterCashier= 0;

    public static void main(String[] args) {
        while (Dispathcer.marketIsOpened()) {
            for (int i = 0; i < Util.random(5); i++) {
                startBuyer();
                startCashier();
                System.out.println("In market: " + Dispathcer.getBuyersInMarket());
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
        System.out.println("In market: " + Dispathcer.getBuyersInMarket());
        System.out.println("CLOSED");
    }

    private static void startBuyer()
    {
        if(Dispathcer.marketIsOpened()) {
            Buyer buyer = new Buyer(++counterBuyer);
            threads.add(buyer);
            buyer.start();
        }
    }

    private static void startCashier() {

            if(ListCashiers.getCount() < 3 && Dispathcer.checkWork()) {
                Cashier cashier = new Cashier(++counterCashier);
                Thread thread = new Thread(cashier);
                thread.start();
                threads.add(thread);


        }
    }

}
