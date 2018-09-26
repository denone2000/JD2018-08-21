package by.it.galushka.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    private static List<Buyer> buyers = new ArrayList<>();

    private static int counterBuyers = 0;

    public static void main(String[] args) {

        for (int actualSecond = 0; actualSecond < 120; actualSecond++) {
            if (actualSecond <= 30) {
                newBuyer(actualSecond);
            } else if (actualSecond > 30 && actualSecond <= 60) {
                if (counterBuyers <= 40 + (30 - actualSecond))
                    newBuyer(actualSecond);
            } else if (actualSecond > 60 && actualSecond <= 90) {
                newBuyer(actualSecond);
            } else {
                if (counterBuyers <= 40 + (30 - actualSecond))
                    newBuyer(actualSecond);
            }
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market is closed.");
    }

    private static void newBuyer(int actualSecond) {
        for (int quantityBuyers = 0; quantityBuyers < Util.getRandom(2); quantityBuyers++) {
            Buyer buyer = new Buyer(++counterBuyers);
            Buyer.pensioneer = counterBuyers % 4 == 0;
            buyers.add(buyer);
            buyer.start();
        }
    }
}
