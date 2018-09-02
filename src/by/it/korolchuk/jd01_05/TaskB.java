package by.it.korolchuk.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {

        for (double a = 0; a <= 2; a = a + 0.2) {
            double y = 0;
            for (double x = 1; x <= 6; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("При a =%4.2f Сумма y =%12.8f\n", a, y);

        }


        double a;
        double b;
        for (double x = -5.5; x < 2; x = x + 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) {
                b = sin(x * x);
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                b = cos(x * x);
            } else if (x / 2 == 0.2) {
                b = 1 / tan(x * x);
            } else {
                System.out.println("вычисления не определены");
                continue;
            }
            a = log10(abs(b + 2.74));
            System.out.printf("При x/2 =%4.2f a =%16.12f\n", x / 2, a);
        }

    }

}
