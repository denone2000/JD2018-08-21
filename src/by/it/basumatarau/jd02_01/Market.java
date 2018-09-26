package by.it.basumatarau.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private static int customerCounter = 0;
    public static void main(String[] args) {

        List<Buyer> buyers = new ArrayList<>();
        for (int i = 0; i < 120; i++) {

            int buyersInDaShop = getBuyersInDaShop(buyers);

            System.out.printf("---->Buyers in the shop: %d, total buyers: %d\n", buyersInDaShop, buyers.size());
            if(i%60>30){
                if(buyersInDaShop<=(40+30-i%60)){
                    introduceCustomers(buyers);
                }
            }else {
                if(buyersInDaShop<=(i%60+10)) {
                    introduceCustomers(buyers);
                }
            }
            Util.sleep(1000);
        }

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }

        System.out.println("Customers left in the market: "+getBuyersInDaShop(buyers));
        System.out.println("Market closed ");
    }

    private static int getBuyersInDaShop(List<Buyer> buyers) {
        int buyersInDaShop=0;
        for (Buyer buyer : buyers) {
            if (buyer.isAlive()){
                buyersInDaShop++;
            }
        }
        return buyersInDaShop;
    }

    private static void introduceCustomers(List<Buyer> buyers) {
        for(int j = 0; j< Util.random(2); j++){
            Buyer buyer = new Buyer(++customerCounter);
            buyers.add(buyer);
            buyer.start();
        }
    }
}
