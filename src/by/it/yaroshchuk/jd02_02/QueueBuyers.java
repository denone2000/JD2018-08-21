package by.it.yaroshchuk.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {

    private final static Deque<Buyer> buyerDeque = new ArrayDeque<>();

    static void addBuyer (Buyer buyer) {
        synchronized (buyerDeque) {
            buyerDeque.addLast(buyer);
            System.out.println(buyer + " added to deque");
        }
    }

    static Buyer pollBuyer() {
        synchronized (buyerDeque) {
            Buyer buyer = buyerDeque.pollFirst();
            if(buyer != null)
                System.out.println(buyer + " left Deque");
            return buyer;
        }
    }

    static  int getCount() {
        synchronized (buyerDeque) {
            return buyerDeque.size();
        }
    }
}
