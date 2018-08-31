package by.it.galushka.jd01_05;

public class TaskA2 {
    public static void taskA2() {
        double y =0;
        double a = 1.21;
        double b = 0.371;
        y = step1A2(a, b, y);
        y = step2A2(a, y);
        y = step3A2(a, b, y);
        printResultA2(a, b, y);
    }

    private static double step1A2(double a, double b, double y) {
        y = Math.tan(Math.pow(a + b, 2));
        return y;
    }

    private static double step2A2(double a, double y) {
        y = y - Math.cbrt(a + 1.5);
        return y;
    }

    private static double step3A2(double a, double b, double y) {
        y = y + a * Math.pow(b, 5) - (b / Math.log(a * a));
        return y;
    }

    private static void printResultA2(double a, double b, double y) {
        System.out.printf("Результат:%ny = %f%nпри a = %.2f b = %.3f%n", y, a, b);
    }
}
