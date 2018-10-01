package by.it.nesterovich.jd02_02;

class Util {

    static int random(int from, int to) {
        return (int) (from + Math.random() * (to - from + 1));
    }

    static void sleep(int millis) {
        try {
            Thread.sleep(millis / Dispatcher.RATE_OF_EXECUTION_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
