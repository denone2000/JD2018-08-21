package by.it.nesterovich.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    //private static List<Buyer> buyers = new ArrayList<>();

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        int counterBuyer = 0;

        for (int i = 1; i <= 2; i++) {
            Cashier cashier = new Cashier(i);
            Thread thread = new Thread(cashier);
            thread.start();
            threads.add(thread);
        }

        while (Dispatcher.marketIsOpened()) {
            for (int i = 0; i < Util.random(0,2); i++) {
                if (Dispatcher.marketIsOpened()) {
                    Buyer buyer = new Buyer(++counterBuyer);
                    threads.add(buyer);
                    buyer.start();
                    System.out.println("In market total:" + Dispatcher.getBuyersInMarket());
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
        System.out.println("In market total:" + Dispatcher.getBuyersInMarket());
        System.out.println("Market closed");

//        for (int currentSecond = 0; currentSecond < 120; currentSecond++) {
//            int secondInMinute = (60 + currentSecond) % 60;
//            System.out.println(currentSecond);
//            System.out.println("In market total: " + Dispatcher.getBuyersInMarket());
//
//            if (secondInMinute < 30 && (Dispatcher.getBuyersInMarket() <= (secondInMinute + 10))) {
//                addBuyer();
//            }
//            if (secondInMinute >= 30 && (Dispatcher.getBuyersInMarket() <= (40 + (30 - secondInMinute)))) {
//                addBuyer();
//            }
//            Util.sleep(1000);
//        }
//        for (Buyer buyer : buyers) {
//            try {
//                buyer.join();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
//        System.out.println("In market total: " + Dispatcher.getBuyersInMarket());
//        System.out.println("Market closed");
    }

//    private static void addBuyer() {
//        for (int i = 0; i < Util.random(0, 2); i++) {
//            Buyer buyer = new Buyer(++counterBuyer);
//            buyers.add(buyer);
//            buyer.start();
//        }
//    }
}
