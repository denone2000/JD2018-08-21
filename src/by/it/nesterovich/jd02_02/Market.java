package by.it.nesterovich.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    //private static List<Buyer> buyers = new ArrayList<>();
    private final static List<Thread> threads = new ArrayList<>();
    private volatile static int counterBuyer = 0;

    public static void main(String[] args) {

        //List<Thread> threads = new ArrayList<>();
        //int counterBuyer = 0;
        int currentTime = 0;

//        for (int i = 1; i <= 2; i++) {
//            Cashier cashier = new Cashier(i);
//            Thread thread = new Thread(cashier);
//            thread.start();
//            threads.add(thread);
//        }

        while (Dispatcher.marketIsOpened()) {
            for (int i = 0; i < Util.random(0, 2); i++) {
                if (Dispatcher.marketIsOpened()) {
                    Buyer buyer = new Buyer(++counterBuyer);
                    Buyer.addBuyersToList(buyer);
                    //threads.add(buyer);
                    buyer.start();
                    System.out.println("In market total:" + Dispatcher.getBuyersInMarket());
                }
            }



//            if (currentTime == 0) {
//                addBuyer();
//            } else if (currentTime % 60 <= 30 && Dispatcher.getBuyersInMarket() < 10 + currentTime % 60) {
//                addBuyer();
//            } else if (currentTime % 60 > 30 && Dispatcher.getBuyersInMarket() < 40 + (30 - currentTime % 60)) {
//                addBuyer();
//            }
//            for (int i = 0; i < Util.random(0, 2); i++) {
//                if (Dispatcher.marketIsOpened()) {
//                    Buyer buyer = new Buyer(++counterBuyer);
//                    Buyer.addBuyersToList(buyer);
//                    //threads.add(buyer);
//                    buyer.start();
//                    System.out.println(" In market total:" + Dispatcher.getBuyersInMarket());
//                }
//            }
            //currentTime++;
            //System.out.println("***current time: " + currentTime + "   Buyers in market: " + Dispatcher.getBuyersInMarket());
            Util.sleep(1000);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println();
        System.out.println("====In market total:" + Dispatcher.getBuyersInMarket());
        System.out.println("Market closed");

        System.out.println("проверка уникальности кассиров");
        for (Thread thread : threads) {
            if (thread.toString().contains("Cashier №")) {
                System.out.println(thread);
            }
        }

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

    static void openCashier(int number) {
        Cashier cashier = new Cashier(number);
        synchronized (cashier) {                     //что не так?
            cashier.start();
            threads.add(cashier);
        }
    }

    static boolean containsName(String name) {
        for (Thread thread : threads) {
            synchronized (thread) {                    //что не так? из-за того, что thread поток, а не объект?
                if (thread.toString().contains(name)) {
                    return true;
                }
            }
        }
        return false;
    }

    static void closeCashier(String name) {
        for (Thread thread : threads) {
            synchronized (thread) {
                if (thread.toString().contains(name)) {
                    if (!thread.isInterrupted()) {
                        thread.interrupt();      //попытка закрыть поток. что не так?
                    }
                }
            }
        }
    }

    private static void addBuyer() {
        for (int i = 0; i < Util.random(0, 2); i++) {
            if (Dispatcher.marketIsOpened()) {
                Buyer buyer = new Buyer(++counterBuyer);
                Buyer.addBuyersToList(buyer);
                //threads.add(buyer);
                buyer.start();
                System.out.println(" In market total:" + Dispatcher.getBuyersInMarket());
            }
        }
//        for (int i = 0; i < Util.random(0, 2); i++) {
//            Buyer buyer = new Buyer(++counterBuyer);
//            buyers.add(buyer);
//            buyer.start();
//        }
    }
}
