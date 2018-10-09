package by.it.yaroshchuk.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        int counterBuyer = 0;



        while (Dispathcer.marketIsOpened()) {
            for (int i = 0; i < Util.random(3); i++) {
                if(Dispathcer.marketIsOpened()) {
                    Buyer buyer = new Buyer(++counterBuyer);
                    threads.add(buyer);
                    buyer.start();
                        if(Dispathcer.checkWork()){
                        for (int j = Dispathcer.getCashiersWork(); j < Dispathcer.requiedWorkCash(); j++){
                            Cashier cashier = new Cashier(j);
                            Thread thread = new Thread(cashier);
                            thread.start();
                            threads.add(thread);

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
        System.out.println("In market: " + Dispathcer.getBuyersInMarket());
        System.out.println("CLOSED");
    }

}
