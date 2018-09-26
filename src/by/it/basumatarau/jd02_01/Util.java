package by.it.basumatarau.jd02_01;

 class Util {

     private static final int KSPEED = 1;

    static int random(int from, int to){
        return (int)(Math.random()*(to-from)+from+1);
    }

    static int random(int notExceeding){
        return (int)(Math.random()*(notExceeding+1));
    }
    static void sleep(int ms){
        try{
            Thread.sleep(ms/KSPEED);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
