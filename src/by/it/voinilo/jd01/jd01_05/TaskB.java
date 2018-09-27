package by.it.voinilo.jd01.jd01_05;

import static java.lang.Math.*;

public class TaskB {

    public static void main(String[] args) {
        step1();
        step2();
    }


    public static void step1() {

        for (double i = 0; i <= 2; i += 0.2) {
            double y = 0;
            for (double j = 1; j <= 6; j++) {


                y = y + pow(7, i) - cos(j);

            }
            System.out.printf("if a=% -3.2f y=% -15.13f\n", i, y);

        }
    }


    public static void step2() {
        for (double x = -6; x < 2; x=x+0.50) {
            if (x <= -4) {
                System.out.println("error");
            } else if (x > 0.4) {
                System.out.println("error");
            } else {
                double b, a;

                if (x > -4 || x <= -2) {
                    b = sin(pow(x, 2));
                    a = log10(abs(b + 2.74));
                    System.out.println(a);
                }
                if (x > -2 || x < 0.4) {
                    b = cos(pow(x, 2));
                    a = log10(abs(b + 2.74));
                    System.out.println(a);
                }
                if (x == 0.4) {
                    b = 1.0 / tan(pow(x, 2));
                    a = log10(abs(b + 2.74));
                    System.out.println(a);
                }


            }


        }

    }
}