package by.it.litvin.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            double sum = 0;
            for (int x = 1; x <= 6; x++) {
                double y = pow(7, a) - cos(x);
                sum = sum + y;

            }
            System.out.println("res=" + sum);
        }
    }

    private static void step2() {
        double beta = 0;
        for (double x = -5.5; x < 2; x += 0.5) {
            if ((x / 2) <= -1 && (x / 2) > -2) {
                beta = sin(x * x);
            }
            if ((x / 2) < 0.2 && (x / 2) > -1) {
                beta = cos(x * x);
            }
            if ((x / 2) == 0.2) {
                beta = (cos(x * x) / sin(x * x));
            }
            double result = log10(abs(beta + 2.74));
            System.out.println("Результат=" + result + "" + "Величина=" + beta);
        }
    }

}
