package by.it.kuzmich.jd01.jd01_05;
import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double z;
        z = cos(pow(x * x + PI / 6,5));
        z = z - sqrt(x * pow (a,3));
        z = z - log(abs((a - 1.12 * x) / 4));
        System.out.printf("При x=%f a=%f z=%f",x,a,z);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y;
        y = tan(pow(a + b,2));
        y = y - cbrt(a + 1.5);
        y = y + a * pow(b,5);
        y = y - (b / log(pow(a,2)));
        System.out.printf("При a=%f b=%f y=%f",a,b,y);
    }

    private static void step3() {
        double x = 12.1;
        for (double a = -5; a <= 12; a+=3.75){
            double m = exp(a * x) - 3.45 * a;
            System.out.printf("При a=%6.2f m=%g%n",a,m);
        }
    }
}
