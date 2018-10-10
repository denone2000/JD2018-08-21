package by.it.kuzmich.jd01.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        chapter1();
        chapter2();
    }

    private static void chapter1() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (double x = 1; x <= 6; x++) {
                y = y + pow(7, a) - cos(x);
            }
            System.out.printf("При a=%3.2f Сумма y =%g\n", a, y);
        }
    }

    private static void chapter2() {
        double b = 0 ,a;
        boolean atrue;
        for (double x = -5.5; x < 2; x += 0.5) {
            atrue = false;
            if (x / 2 > -2 && x / 2 <= -1) {
                b = sin(pow(x, 2));
                atrue = true;
            }
            if (x / 2 > -1 && x / 2 < 0.2) {
                b = cos(x * x);
                atrue = true;
            }
            if (x / 2 == 0.2) {
                b = 1 / tan(x * x);
                atrue = true;
            }
            a = log10(abs(b + 2.74));
            if (atrue) {
                System.out.printf("При x/2=%3.2f a = %g%n", x / 2, a);
            } else {
                System.out.printf("При x/2=%3.2f вычисления не определены%n", x / 2);
            }
        }
    }
}


