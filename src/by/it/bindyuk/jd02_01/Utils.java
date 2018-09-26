package by.it.bindyuk.jd02_01;

class Utils {

    static int random(int from, int to) {
        return (int) (from + Math.random() * (to - from + 1));
    }

    static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

///Dispatcher.KOEFSPEED
}
