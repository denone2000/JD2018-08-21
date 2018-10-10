package by.it.galushka.demo.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Threads extends Thread {

    private static AtomicInteger atomic = new AtomicInteger(0);

    private static Semaphore semaphore = new Semaphore(2);

    Threads(int number) {
        super("Thread №" + number);
    }

    @Override
    public void run() {
        System.out.println(this + " created.");
        try {
            System.out.println(atomic.get());
            semaphore.acquire();
            atomic.incrementAndGet();
            createThread();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
            atomic.decrementAndGet();
        }
    }

    private void createThread() {
        System.out.println(this + " started work.");
        Util.sleep(Util.getRandom(500, 2000));
        System.out.println(this + " ended work.");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
