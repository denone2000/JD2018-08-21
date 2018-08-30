package by.it.galushka.jd01_05;

public class TaskA {
    public static void main(String[] args) {
        double z = 0;
        double a = 756.13;
        double x = 0.3;
        z = step1(x, z);
        z = step2(a,x,z);
        z = step3(a,x,z);
        printResult(a, x, z);
    }

    private static double step1(double x, double z) {
        System.out.println(z);
        z = Math.cos(Math.pow(x * x + Math.PI / 6, 5));
        //z = Math.pow(Math.cos(x * x + Math.PI / 6), 5);
        System.out.println(z);
        return z;
    }

    private static double step2(double a, double x, double z) {
        System.out.println(z);
        z = z - Math.sqrt(x * Math.pow(a, 3));
        System.out.println(z);
        return z;
    }

    private static double step3(double a, double x, double z) {
        System.out.println(z);
        double y = Math.abs((a - 1.12*x) / 4);
        System.out.println(y);
        z = z - Math.log(y);
        System.out.println(Math.log(y));
        System.out.println(z);
        return z;
    }

    private static void printResult(double a, double x, double z) {
        System.out.printf("Результат:%nz = %.4f%nпри a = %.2f x = %.1f", z, a, x);
    }
}
