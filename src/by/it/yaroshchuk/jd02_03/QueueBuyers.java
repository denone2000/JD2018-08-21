package by.it.yaroshchuk.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class QueueBuyers {

    private final static BlockingDeque<Buyer> buyerBlockingDeque = new LinkedBlockingDeque<>(30);

    static void addBuyer (Buyer buyer) {
        try {
            buyerBlockingDeque.putLast(buyer);
            System.out.println(buyer + " added to Deque");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer pollBuyer() {
        Buyer buyer = buyerBlockingDeque.pollFirst();
        if(buyer != null)
            System.out.println(buyer + " left Deque");
        return buyer;
    }

    static  int getCount() {
        return buyerBlockingDeque.size();
    }
}
