package by.it.kuzmich.jd02.jd_02_01;

 class Utility {

    private static final int SPEED = 1;

     static int random (int start,int end){
        return (int)( Math.random()*(end - start)+(start+1));
    }

    static int random (int end){
    return random(0,end);
    }

    static void sleep(int spatki){
        try {
            Thread.sleep(spatki/SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
