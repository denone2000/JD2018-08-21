package by.it.galushka.jd02_01;

public class Market {

    public static void main(String[] args) {

        int counterBuyers = 0;

        for (int actualSecond = 0; actualSecond < 120; actualSecond++) {
            for (int quantityBuyers = 0; quantityBuyers<Util.getRandom(2); quantityBuyers++){
                Buyer buyer = new Buyer(++counterBuyers);
                buyer.start();
            }
        }
    }
}
