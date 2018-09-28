package by.it.nesterovich.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {

    private final static Deque<Buyer> BUYER_DEQUE = new ArrayDeque<>();

    static void addBuyer(Buyer buyer) {
        synchronized (BUYER_DEQUE) {
            BUYER_DEQUE.addLast(buyer);
            if (getCount() == 1) {
                Market.openCashier(1);
               // Market.closeCashier(1);
            }
            if (getCount() == 6) {
                Market.openCashier(2);
               // Market.closeCashier(2);
            }
            if (getCount() == 11) {
                Market.openCashier(3);
                //Market.closeCashier(4);
            }
            if (getCount() == 16) {
                Market.openCashier(4);
               // Market.closeCashier(5);
            }
            if (getCount() == 21) {
                Market.openCashier(5);
            }
            System.out.println(" " + buyer + " added to Deque" + "                 add   size queue:" + getCount());
        }
    }

    static Buyer pollBuyer() {
        synchronized (BUYER_DEQUE) {
            Buyer buyer = BUYER_DEQUE.pollFirst();
            if (buyer != null) {
                System.out.println(" " + buyer + " poll from Deque" + "                 poll   size queue:" + getCount());
            }
            return buyer;
        }
    }

    static int getCount() {
        synchronized (BUYER_DEQUE) {
            return BUYER_DEQUE.size();
        }
    }
}