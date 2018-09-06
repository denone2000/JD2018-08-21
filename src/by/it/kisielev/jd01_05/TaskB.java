package by.it.kisielev.jd01_05;

public class TaskB {

    public static  void main(String[] args){
        step1();
        step2();
    }

    private static void step1(){
        for (double a = 0; a <=2; a=a+0.2) {
            for (double x = 1; x <= 6; x++) {
                double y = (7 * a) - Math.cos(x);
                System.out.printf("При a=%3.3f. y=%g\n",a,y);
            }
        }


    }
    static void  step2(){

    }
}
