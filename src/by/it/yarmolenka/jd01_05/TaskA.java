package by.it.yarmolenka.jd01_05;

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
        double z = Math.cos(Math.pow(x * x + Math.PI / 6, 5));
        z = z - Math.sqrt(x * Math.pow(a, 3));
        z = z - Math.log(Math.abs((a - 1.12 * x) / 4));
        System.out.printf("При x=%f a=%f z=%f", x, a, z);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow((a + b), 2)) - cbrt(a + 1.5) + a * pow(b, 5) - (b / log(pow(a, 2)));
        System.out.println(y);
    }

    private static void step3() {
        double x = 12.1;

        for (double a = -5; a <= 12; a = a + 3.75) {
            double f = (pow(E, a * x) - 3.45 * a);
            System.out.printf("a=% -4.2f   f=% -7.4f", a, f);
            System.out.println();

        }
    }
}
