package by.it.korzik.jd02_03;

import java.util.ArrayDeque;
import java.util.Deque;

public class BuyersQueue {

    private final static Deque<Buyer> BUYER_DEQUE = new ArrayDeque<>();

    static void addBuyer(Buyer buyer) {
        synchronized (BUYER_DEQUE) {
            BUYER_DEQUE.addLast(buyer);
            System.out.println(buyer + " стал в очередь");
        }
    }

    static Buyer pollBuyer() {
        synchronized (BUYER_DEQUE) {
            Buyer buyer = BUYER_DEQUE.pollFirst();
            if (buyer != null)
                System.out.println(buyer + " вышел из очереди");
            return buyer;
        }
    }

    static int getCount() {
        synchronized (BUYER_DEQUE) {
            return BUYER_DEQUE.size();
        }
    }


}
