package by.it.korzik.jd02_02;

class Util {
    private static final int SPEED = 100;
    static volatile int plan = 0;

    private static volatile int buyerCount = 0;

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

    public synchronized static void addBuyer() {
        buyerCount++;
    }

    synchronized static boolean marketOpen() {
        return buyerCount < 100;
    }

    static boolean planComplete() {
        return plan == buyerCount;
    }
}
