package by.it.voinilo.jd02.jd02_02;//package by.it.voinilo.jd02.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

public class Runner {
    static int countBuyers= 0;

    public static void main(String[] args) throws InterruptedException{
        Thread cashier = null;
        Queue <Buyer> queue = new ArrayDeque<>();
        while (countBuyers<100){
            Thread.sleep(100);
            int count = Custom.rndAtoB(0,2);
            for (int i = 0; i < count; i++) {
                countBuyers++;
                if (countBuyers <= 100)
                {
                    Buyer buyer = new Buyer(countBuyers);
                    queue.add(buyer);
                }
            }

        }
        if (QueueBuyers.getCount()>2 && cashier == null){

            for (int i = 1; i <= 5; i++) {

            cashier = new Thread(new Cashier(i));
                System.out.println(cashier.getState());
            cashier.start();}
        }

    }
}
