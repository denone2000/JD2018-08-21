package by.it.korzik.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Util {
    private static final int SPEED = 100;
    static AtomicInteger plan = new AtomicInteger(0);

    private static AtomicInteger buyerCount = new AtomicInteger(0);

    static int random(int from, int to) {
        return (int) (Math.random() * (to - from) + (from + 1));
    }

    static int random(int to) {
        return random(0, to);
    }

    static void sleep(int millis) {
        try {
            Thread.sleep(millis / SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public  static void addBuyer() {
        buyerCount.addAndGet(1);
    }

    static boolean marketOpen() {
        return buyerCount.get() < 100;
    }

    static boolean planComplete() {
        return plan.get() == buyerCount.get();
    }
}
