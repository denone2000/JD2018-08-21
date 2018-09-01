package by.it.bindyuk.jd01_05;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double z = Math.cos(Math.pow(x * x + Math.PI / 6, 5.0));
        z = z - Math.sqrt(x * Math.pow(a, 3));
        z = z - Math.log(Math.abs((a - 1.12 * x) / 4));
        System.out.printf("При х=%f a=%f x=%f", x, a, z);
        System.out.println();
        double z1 = (Math.cos(Math.pow(x * x + Math.PI / 6, 5.0))) - (Math.sqrt(x * Math.pow(a, 3))) -
                (Math.log(Math.abs((a - 1.12 * x) / 4)));
        System.out.println("одним действием: z = " + z1);
    }

    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double buff = 3;
        double y = (Math.tan(Math.pow((a + b), 2.0))) - (Math.pow(a + 1.5, 1.0 / buff)) + (a * Math.pow(b, 5)) -
                (b / (Math.log(a * a)));
        System.out.println("result y = " + y);
    }

    private static void step3() {
        double x = 12.1;


        for (double a = -5; a <= 12; a+=3.75) {
            double f = (Math.pow(Math.E, a*x)) - (3.45*a);
            System.out.println("При a= " + a + " " + "f=" + f);
        }
    }
}
