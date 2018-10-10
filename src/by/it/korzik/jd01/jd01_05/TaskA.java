package by.it.korzik.jd01.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        double z = 0, a = 756.13, x = 0.3;
        z = cos(pow((pow(x, 2) + (PI / 6)), 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4.0));
        System.out.println(z);
    }

    private static void step2() {
        double a = 1.21, b = 0.371;
        double y = tan(pow(a + b, 2)) - cbrt(a + 1.5) + a * pow(b, 5) - b / log(a * a);
        System.out.println("y="+y);
    }

    private static void step3() {
    double x=12.1;
    for (double a=-5;a>=-5&&a<=12;a+=3.75){
        double f = exp(a*x)-3.45*a;
        System.out.printf("при а=%6.2f f=%g\n",a,f);
    }
    }
}
