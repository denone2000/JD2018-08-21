package by.it.nesterovich.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    private static List<Buyer> buyers = new ArrayList<>();
    private static int counterBuyer = 0;

    public static void main(String[] args) {

        for (int currentSecond = 0; currentSecond < 120; currentSecond++) {
            int secondInMinute = (60 + currentSecond) % 60;
            System.out.println(currentSecond);
            System.out.println("In market total: " + Dispatcher.getBuyersInMarket());

            if (secondInMinute < 30) {
                while (Dispatcher.getBuyersInMarket() < (secondInMinute + 11)) {
                    addBuyer();
                }
            }
            if (secondInMinute >= 30) {
                while (Dispatcher.getBuyersInMarket() < (40 + (30 - secondInMinute))) {
                    addBuyer();
                }
            }
            //Util.sleep(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("In market total: " + Dispatcher.getBuyersInMarket());
        System.out.println("Market closed");
    }

    private static void addBuyer() {
        for (int i = 0; i < Util.random(0, 2); i++) {
            Buyer buyer = new Buyer(++counterBuyer);
            buyers.add(buyer);
            buyer.start();
        }
    }
}
