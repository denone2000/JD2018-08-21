package by.it.akhmelev.jd01_05;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }


    private static void step4() {
        for (double a = 0; a <= 2; a = a + 0.2) {
            double sum = 0;
            for (int x = 1; x <= 6; x++) {
                sum += Math.pow(7, a) - Math.cos(x);
            }
            System.out.printf("y=%f for a=%f\n", sum, a);
        }
    }

    private static void step5() {
    }
}
