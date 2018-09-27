package by.it.bindyuk.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {

        Goods.goods.put("Bread", 1.5);
        Goods.goods.put("Salt", 2.0);
        Goods.goods.put("Potatoes", 3.5);
        Goods.goods.put("Chocolate", 2.0);
        Goods.goods.put("Tomatoes", 4.3);
        Goods.goods.put("Carrot", 3.6);
        Goods.goods.put("Water", 0.7);
        Goods.goods.put("Beer", 2.5);
        Goods.goods.put("Meat", 10.7);
        Goods.goods.put("Apple", 5.2);

        List<Buyer> buyers = new ArrayList<>();
        int counterBuyer = 0;



        for (int second = 0; second < 120; second++) {
            for (int i = 0; i < Utils.random(0, 2); i++) {
                Buyer buyer = new Buyer(++counterBuyer);
                buyers.add(buyer);
                buyer.start();
                System.out.println("Now in Market: " + Dispatcher.getBuyersInMarket());
                Utils.sleep(1000);
            }
        }

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Now in Market: " + Dispatcher.getBuyersInMarket());
        System.out.println("Market was closed");
    }
}
