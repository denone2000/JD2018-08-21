package by.it.basumatarau.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Market {
    private static int customerCounter = 0;
    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        HashMap<Thread,Object> monitors = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(i);
            Thread th = new Thread(cashier);
            monitors.put(th,cashier.getCASHIER_MONITOR());
            threads.add(th);
            th.start();
        }

        int timeSec=0;
        while (Dispatcher.isNotOnTarget()) {
            timeSec++;
            int buyersInDaShop = Dispatcher.getBuyersInMarket();


            //System.out.println("Cashiers working: "+Dispatcher.getOpenCashiers());
            //System.out.println("Cashiers on shift: "+Dispatcher.getCashiersOnShift());
            //System.out.printf("---->Buyers in the shop: %d at %ds\n", buyersInDaShop, timeSec);
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

            if(Dispatcher.getOpenCashiers()*5<Dispatcher.getBuyersInMarket() &&
                    Dispatcher.getOpenCashiers()!=Dispatcher.getCashiersOnShift() &&
                    Buyer.queuingBuyers()>0){
                for (Map.Entry<Thread, Object> entry: monitors.entrySet()) {
                    if(entry.getKey().getState().equals(Thread.State.WAITING)){
                        synchronized (entry.getValue()){
                            //System.out.println("One more cashier is to be open...");
                            Dispatcher.openCashier();
                            entry.getValue().notify();
                        }
                        break;
                    }
                }
            }
            Util.sleep(1000);
        }


        for (Map.Entry<Thread, Object> entry: monitors.entrySet()) {
            if(entry.getKey().getState().equals(Thread.State.WAITING)){
                synchronized (entry.getValue()){
                    entry.getValue().notify();
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
