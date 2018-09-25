package by.it.akhmelev.jd02_01;

class Util {

    static int random(int from, int to){
        return (int)(from+Math.random()*(to-from+1));
    }

    static int random(int max){
        return random(0,max);
    }

    static void sleep(int millis){
        try {
            Thread.sleep(millis/Dispathcer.KSPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
