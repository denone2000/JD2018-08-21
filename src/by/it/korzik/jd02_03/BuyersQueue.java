package by.it.korzik.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

 class BuyersQueue {

    private final static BlockingDeque<Buyer> BUYER_BLOCKING_DEQUE = new LinkedBlockingDeque<>(30);

    static void addBuyer(Buyer buyer) {
        try {
            BUYER_BLOCKING_DEQUE.putLast(buyer);
            System.out.println(buyer + " добавлен в очередь");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer pollBuyer() {
        Buyer buyer = BUYER_BLOCKING_DEQUE.pollFirst();
        if (buyer != null)
            System.out.println(buyer + " извлечен из очереди");
        return buyer;

    }

    static int getCount() {
        return BUYER_BLOCKING_DEQUE.size();
    }



}
