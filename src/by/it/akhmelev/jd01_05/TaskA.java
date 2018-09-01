package by.it.akhmelev.jd01_05;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a=756.13;
        double x=0.3;
        double z=Math.cos(Math.pow(x*x+Math.PI/6,5));
        z=z-Math.sqrt(x*Math.pow(a,3));
        z=z-Math.log(Math.abs((a-1.12*x)/4));
        System.out.printf("При x=%f a=%f z=%f",x,a,z);
    }

    private static void step2() {
    }

    private static void step3() {

    }

}
