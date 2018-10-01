package by.it.akhmelev.jd02_02;

import java.util.ArrayDeque;
import java.util.Deque;

class QueueBuyers {

    private final static Deque<Buyer> BUYER_DEQUE = new ArrayDeque<>();

    static void addBuyer(Buyer buyer) {
        synchronized (BUYER_DEQUE) {
            BUYER_DEQUE.addLast(buyer);
            System.out.println("\t\tОЧЕРЕДЬ: "+buyer + " добавлен в очередь");
        }
    }

    static Buyer pollBuyer() {
        synchronized (BUYER_DEQUE) {
            Buyer buyer = BUYER_DEQUE.pollFirst();
            if (buyer != null)
                System.out.println("\t\tОЧЕРЕДЬ: "+buyer + " извлечен из очереди");
            return buyer;
        }
    }

    static int getCount() {
        synchronized (BUYER_DEQUE) {
            return BUYER_DEQUE.size();
        }
    }


}
