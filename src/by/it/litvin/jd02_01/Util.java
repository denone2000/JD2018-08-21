package by.it.litvin.jd02_01;

class Util {

    static int randomInt(int from, int to){
        return (int)(from+Math.random()*(to-from+1));
    }

    static void sleep(int millis){
        try {
            Thread.sleep(millis/ Dispathcer.KSPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    static double randomDouble(double from, double to){
        return from+Math.random()*(to-from+1);
    }

}
