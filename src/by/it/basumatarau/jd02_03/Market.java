package by.it.basumatarau.jd02_03;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    private final static int CASHIERS_NUM = 2;
    private static int customerCounter = 0;
    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        List<Cashier> cashiers = new LinkedList<>();

        ExecutorService executor = Executors.newFixedThreadPool(CASHIERS_NUM);
        for (int i = 1; i <= CASHIERS_NUM; i++) {
            Cashier cashier = new Cashier(i);
            cashiers.add(cashier);
            executor.execute(cashier);
        }

        int timeSec=0;
        while (Dispatcher.isNotOnTarget()) {
            timeSec++;
            int buyersInDaShop = Dispatcher.getBuyersInMarket();

            System.out.println("Cashiers working: "+Dispatcher.getOpenCashiers());
            //System.out.println("Cashiers on shift: "+Dispatcher.getCashiersOnShift());
            System.out.printf("---->Buyers in the shop: %d at %ds\n", buyersInDaShop, timeSec);
            System.out.println(Util.printMarketStatus());

            if (timeSec % 60 > 30) {
                if (buyersInDaShop <= (40 + 30 - (timeSec % 60))) {
                    introduceCustomers(threads);
                }
            } else {
                if (buyersInDaShop <= ((timeSec % 60) + 10)) {
                    introduceCustomers(threads);
                }
            }

            /* open one of the closed cashiers if(condition1&&condition2&&condition3)
             * condition1: too much customers
             * condition2: not all the cashiers on shift are working
             * condition3: there is somebody in the queue
            */
            if(Dispatcher.getOpenCashiers()*5<Dispatcher.getBuyersInMarket() &&
                    Dispatcher.getOpenCashiers()!=Dispatcher.getCashiersOnShift() &&
                    Buyer.queuingBuyers()>0){
                for (Cashier cashier : cashiers) {
                    if(!cashier.isWorking()){
                        synchronized (cashier.getCASHIER_MONITOR()){
                            Dispatcher.openCashier();
                            cashier.getCASHIER_MONITOR().notify();
                        }
                        break;
                    }

                }
            }
            Util.sleep(1000);
        }

        executor.shutdown();
        for (Cashier cashier : cashiers) {
            if(!cashier.isWorking()) {
                synchronized (cashier.getCASHIER_MONITOR()) {
                    cashier.getCASHIER_MONITOR().notify();
                }
            }
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("Market closed ");
        System.out.println("Cashiers working: "+Dispatcher.getOpenCashiers());
        System.out.println("Cashiers on shift: "+Dispatcher.getCashiersOnShift());
        System.out.println("Customers serviced: "+Dispatcher.getBuyersLeftMarket());
        System.out.println("Customers left in the market: "+Dispatcher.getBuyersInMarket());
    }

    private static void introduceCustomers(List<Thread> threads) {
        for(int j = 0; j< Util.random(4); j++){
            if (Dispatcher.isOpen()) {
                Buyer buyer = new Buyer(++customerCounter);
                threads.add(buyer);
                buyer.start();
            }
        }
    }
}
