package by.it.voinilo.jd01.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        main1();
        main2();
        main3();
    }
    public static void main1() {


        double x = 0.3, a = 756.13;
        double z1 = cos(pow((pow(x, 2) + PI / 6), 5)) - sqrt(x * pow(a, 3)) - log(abs((a - 1.12 * x) / 4));
        System.out.println(z1);
    }

    public static void main2() {
double a=1.21, b=0.371,y;
y= tan(pow((a+b),2))-cbrt(a+1.5)+a*pow(b,5)-(b/log(pow(a,2)));
        System.out.println(y);
    }

    public static void main3() {
        double x=12.1;

        for (double a=-5; a<=12 ; a=a+3.75) {
            double f= (pow(E, a*x)-3.45*a);
            System.out.printf("a=% -4.2f   f=% -7.4f",a,f);
            System.out.println();
        }
    }
}