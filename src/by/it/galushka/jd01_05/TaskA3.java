package by.it.galushka.jd01_05;

public class TaskA3 {

    public static void taskA3() {
        double x = 12.1;
        for (double a = -5; a <= 12 ; a = a + 3.75) {
            double f = Math.exp(a * x) - 3.45 * a;
            System.out.printf("При a = %5.2f f = %f%n", a, f);
        }
    }
}
