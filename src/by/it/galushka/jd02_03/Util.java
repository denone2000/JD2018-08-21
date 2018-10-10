package by.it.galushka.jd02_03;

class Util {

    static int getRandom(int from, int to){
        return (int)(from + Math.random()*(to-from+1));
    }

    static int getRandom(int max) {
        return getRandom(0, max);
    }

    static void sleep(int timeMillis){
        try {
            Thread.sleep(timeMillis/ Dispatcher.getXspeed());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
