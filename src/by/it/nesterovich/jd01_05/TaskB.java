package by.it.nesterovich.jd01_05;

public class TaskB {

    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        for (double a = 0; a <= 2; a += 0.2) {
            double y = 0;
            for (int x = 0; x <= 6; x++) {
                y += Math.pow(7, a) - Math.cos(x);
            }
            System.out.printf("При а=%6.2f Сумма y=%6.4f\n", a, y);
        }
    }

    private static void step2() {
        for (double x = -5.5; x < 2; x += 0.5) {
            double b = 0;
            if (-2 < x / 2.0 && x / 2.0 <= -1) {
                b = Math.sin(Math.pow(x, 2));
            } else if (-1 < x / 2.0 && x / 2.0 < 0.2) {
                b = Math.cos(Math.pow(x, 2));
            } else if (x / 2.0 == 0.2) {
                b = 1 / Math.tan(Math.pow(x, 2));
            } else {
                System.out.printf("При x/2=%6.2f  вычисления не определены\n", x);
            }
            double a = Math.log10(Math.abs(b + 2.74));
            System.out.printf("При x/2=%6.2f a=%g\n", x, a);
        }
    }
}
