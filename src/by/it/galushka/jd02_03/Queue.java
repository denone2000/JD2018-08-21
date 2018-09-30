package by.it.galushka.jd02_03;

import java.util.ArrayDeque;
import java.util.Deque;

class Queue {

    private final static Deque<Buyer> BUYERS_DEQUE = new ArrayDeque<>();

    static void addBuyerInQueue(Buyer buyer) {
        synchronized (BUYERS_DEQUE) {
            BUYERS_DEQUE.addLast(buyer);
            System.out.println(buyer + " added to queue.");
        }
    }

    static Buyer pollBuyerFromQueue() {
        synchronized (BUYERS_DEQUE) {
            Buyer buyer = BUYERS_DEQUE.pollFirst();
            if (buyer != null) {
                System.out.println(buyer + " poll from queue.");
            }
            return buyer;
        }
    }

    static int getQueueSize() {
        synchronized (BUYERS_DEQUE) {
            return BUYERS_DEQUE.size();
        }
    }
}
