package by.it.voinilo.jd02.jd02_01;

import java.util.ArrayDeque;
import java.util.Queue;

public class Runner {
    static int countBuyers= 0;

    public static void main(String[] args) throws InterruptedException{
        Queue <Buyer> queue = new ArrayDeque<>();
        while (countBuyers<10){
            Thread.sleep(1000);
            int count = Custom.rndAtoB(0,2);
            for (int i = 0; i < count; i++) {
                countBuyers++;
                if (countBuyers <= 10)
                {
                    Buyer buyer = new Buyer(countBuyers);
                    queue.add(buyer);
                }
            }
        }

    }
}
