package by.it.nesterovich.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {

    private final static Deque<Buyer> BUYER_DEQUE = new ArrayDeque<>();

    static void addBuyer(Buyer buyer) {
        synchronized (BUYER_DEQUE) {
            BUYER_DEQUE.addLast(buyer);
            if (getCount() >= 1 && !Market.containsName("Cashier №1")) {
                Market.openCashier(1);
            }
            if (getCount() >= 6 && !Market.containsName("Cashier №2")) {
                Market.openCashier(2);
            }
            if (getCount() >= 11 && !Market.containsName("Cashier №3")) {
                Market.openCashier(3);
            }
            if (getCount() >= 16 && !Market.containsName("Cashier №4")) {
                Market.openCashier(4);
            }
            if (getCount() >= 21 && !Market.containsName("Cashier №5")) {
                Market.openCashier(5);
            }
            if (getCount() < 21 && Market.containsName("Cashier №5")){  //что не так?
                Market.closeCashier("Cashier №5");
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