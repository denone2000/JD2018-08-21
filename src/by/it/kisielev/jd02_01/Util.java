package by.it.kisielev.jd02_01;

public class Util {
    static int random(int from, int to){return  (int/*формат выводачисел*/)(from+ Math.random()*(to-from+1));}

    static int random(){return  random(0, 2);}

    static void sleep(int millis){
        try {
            Thread.sleep(millis / Dispathcer.KSPEED);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
