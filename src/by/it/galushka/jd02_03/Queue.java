package by.it.galushka.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class Queue {

    private final static BlockingDeque<Buyer> BUYERS_DEQUE = new LinkedBlockingDeque<>(30);

    static void addBuyerInQueue(Buyer buyer) {
        try {
            BUYERS_DEQUE.putLast(buyer);
            System.out.println(buyer + " added to queue.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer pollBuyerFromQueue() {
        Buyer buyer = BUYERS_DEQUE.pollFirst();
        if (buyer != null) {
            System.out.println(buyer + " poll from queue.");
        }
        return buyer;
    }

    static int getQueueSize() {
        return BUYERS_DEQUE.size();
    }
}
