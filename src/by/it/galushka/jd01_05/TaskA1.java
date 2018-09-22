package by.it.galushka.jd01_05;

public class TaskA1 {
    public static void taskA1() {
        double z = 0;
        double a = 756.13;
        double x = 0.3;
        z = step1A1(x, z);
        z = step2A1(a,x,z);
        z = step3A1(a,x,z);
        printResultA1(a, x, z);
    }

    private static double step1A1(double x, double z) {
        z = Math.cos(Math.pow(x * x + Math.PI / 6, 5));
        return z;
    }

    private static double step2A1(double a, double x, double z) {
        z = z - Math.sqrt(x * Math.pow(a, 3));
        return z;
    }

    private static double step3A1(double a, double x, double z) {
        double y = Math.abs((a - 1.12*x) / 4);
        z = z - Math.log(y);
        return z;
    }

    private static void printResultA1(double a, double x, double z) {
        System.out.printf("Результат:%nz = %f%nпри a = %.2f x = %.1f", z, a, x);
        System.out.println("\n");
    }
}
