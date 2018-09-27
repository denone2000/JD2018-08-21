package by.it.korolchuk.jd02_02;

class Util {
    static int random(int from, int to) {
        return (int) (Math.random() * (to - from + 1));
    }

    static int random(int max) {
        return random(0, max);
    }

    static void sleep(int millis) {
        try {
            Thread.sleep(millis / Dispatcher.KoefSpeed);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
