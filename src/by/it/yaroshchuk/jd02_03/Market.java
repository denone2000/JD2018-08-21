package by.it.yaroshchuk.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        int counterBuyer = 0;

        ExecutorService executors = Executors.newFixedThreadPool(5);

        while (Dispathcer.marketIsOpened()) {
            for (int i = 0; i < Util.random(3); i++) {
                if(Dispathcer.marketIsOpened()) {
                    Buyer buyer = new Buyer(++counterBuyer);
                    threads.add(buyer);
                    buyer.start();
                        if(Dispathcer.checkWork()){
                        for (int j = Dispathcer.getCashiersWork(); j < Dispathcer.requiedWorkCash(); j++){
                            Cashier cashier = new Cashier(j);
                            executors.execute(cashier);
                       
                        }
                    }
                    System.out.println("In market: " + Dispathcer.getBuyersInMarket());
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
        executors.shutdown();
        System.out.println("In market: " + Dispathcer.getBuyersInMarket());
        System.out.println("CLOSED");
    }

}
