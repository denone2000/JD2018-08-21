package by.it.nesterovich.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        List<Buyer> buyers = new ArrayList<>();
        int counterBuyer = 0;
        for (int currentSecond = 0; currentSecond < 120; currentSecond++) {
            for (int i = 0; i < Util.random(); i++) {
                Buyer buyer = new Buyer(++counterBuyer);
                buyers.add(buyer);
                buyer.start();
                System.out.println("In market total:" + Dispatcher.getBuyersInMarket());
                Util.sleep(1000);
            }
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("In market total:" + Dispatcher.getBuyersInMarket());
        System.out.println("Market closed");
    }
}
