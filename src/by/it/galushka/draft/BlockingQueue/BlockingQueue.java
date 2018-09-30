package by.it.galushka.draft.BlockingQueue;

import java.util.concurrent.LinkedBlockingDeque;

public class BlockingQueue {
    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingDeque queue = new LinkedBlockingDeque(2);
        queue.putLast(1);
        System.out.println(queue);
        queue.putLast(2);
        System.out.println(queue);
        //========================
        // если не сделать poll программа зациклится и будет ждать о очереди появится место
        queue.pollFirst();
        //========================
        System.out.println(queue);
        queue.putLast(3);
        System.out.println(queue);

    }
}
