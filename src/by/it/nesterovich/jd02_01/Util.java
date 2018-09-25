package by.it.nesterovich.jd02_01;

class Util {

    static int random(int from, int to) {
        return (int) (from + Math.random() * (to - from + 1));
    }

    static int random() {
        return random(0, 2);
    }

    static void sleep(int millis) {
        try {
            Thread.sleep(millis / Dispatcher.RATE_OF_EXECUTION_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
