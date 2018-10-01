package by.it.litvin.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {

    private final static Deque<Buyer> BUYER_DEQUE = new ArrayDeque<>();

    static void addBuyer(Buyer buyer) {
        synchronized (BUYER_DEQUE) {
            BUYER_DEQUE.addLast(buyer);
            System.out.println(buyer + " added to Deque");
        }
    }

    static Buyer pollBuyer() {
        synchronized (BUYER_DEQUE) {
            Buyer buyer = BUYER_DEQUE.pollFirst();
            if (buyer != null)
                System.out.println(buyer + " poll from Deque");
            return buyer;
        }
    }

    static int getCount() {
        synchronized (BUYER_DEQUE) {
            return BUYER_DEQUE.size();
        }
    }


}
