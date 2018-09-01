package by.it.galushka.jd01_05;

public class TaskB {
    public static void main(String[] args) {
        taskB1();
        taskB2();
    }

    private static void taskB1() {
        for (double a = 0; a < 2; a = a + 0.2) {
            double y = 0;
            for (int x = 0; x <= 6; x++) {
                double sum = Math.pow(7, a) - Math.cos(x);
                y = y + sum;
            }
            System.out.printf("При a = %3.1f Сумма y = %f%n", a, y);
        }
        System.out.println();
    }

    private static void taskB2() {
        for (double x = -5.5; x < 2; x = x + 0.5) {
            double b;
            double a;
            if (x / 2 > -2 && x / 2 <= -1) {
                b = Math.sin(x * x);
                a = Math.log10((Math.abs(b + 2.74)));
                System.out.printf("При x/2 = %3.2f а = %f%n", x/2, a);
            }
            else if (x / 2 > -1 && x / 2 < 0.2) {
                b = Math.cos(x * x);
                a = Math.log10(Math.abs(b + 2.74));
                System.out.printf("При x/2 = %3.2f а = %f%n", x/2, a);
            }
            else if (x / 2 == 0.2) {
                b = 1 / Math.tan(x * x);
                a = Math.log10(Math.abs(b + 2.74));
                System.out.printf("При x/2 = %3.2f а = %f%n", x/2, a);
            }
            else {
                System.out.printf("При x/2 = %3.2f вычисление не определяется%n", x/2);
            }
        }
        System.out.println();
    }
}
