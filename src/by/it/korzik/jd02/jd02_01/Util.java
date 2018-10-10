package by.it.korzik.jd02.jd02_01;

class Util {
    private static final int SPEED = 100;

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

}
