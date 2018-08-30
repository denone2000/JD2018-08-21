package by.it.bindyuk.jd01_05;

public class TaskB {
    public static void main(String[] args) {
        step4();
        step5();
    }

    private static void step4() {
        double y = 0;
        for (double a = 0; a <= 2; a += 0.2) {
            for (double x = 1; x <= 6; x++) {
                y += Math.pow(7, a) - Math.cos(x);
            }
            System.out.printf("При а= % 4.2f y=% 12.10f\n", a, y);
        }
    }

    private static void step5() {
        for (double x = -5.5; x < 2; x += 0.5) {
            if (x <= -4.0 || x > 0.4) {
                System.out.println("При x/2= " + (x / 2) + " вычисления не определены");
            } else if (x > -4.0 && x <= -2.0) {
                double b = Math.sin(Math.pow(x, 2.0));
                double a = Math.log10(Math.abs(b + 2.74));
                System.out.println("При x/2= " + (x / 2) + " a = " + a);
            } else if (x > -2.0 && x < 0.4) {
                double b = Math.cos(x * x);
                double a = Math.log10(Math.abs(b + 2.74));
                System.out.println("При x/2= " + (x / 2) + " a = " + a);
            } else if (x == 0.4) {
                double b = (1 / (Math.tan(x * x)));
                double a = Math.log10(Math.abs(b + 2.74));
                System.out.println("При x/2= " + (x / 2) + " a = " + a);
            }
        }
    }


}
