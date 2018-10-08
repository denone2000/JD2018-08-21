package by.it.voinilo.jd02.jd02_02;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class QueueBuyers {


    private final static ArrayDeque<Buyer> queue = new ArrayDeque<>();

    static void add(Buyer buyer) throws InterruptedException {
        synchronized (queue) {
            queue.addLast(buyer);
//            queue.wait();
        }
    }
    static Buyer extract (){
        synchronized (queue){
            return queue.pollFirst();
        }
    }
  static   int getCount(){
        synchronized (queue){
            return queue.size();
        }
    }


}
