package by.it.artemliashkov.jd01_05;

import static java.lang.Math.*;
import static java.lang.Math.abs;

public class TaskB {
    public   static void main(String args[])
    {
        step1();
        step2();
    }

    public static void step1()
    {
        double y[]=new double[11];
        double r[]=new double[11];
        int i=0;
        double res=0.0;
        for(double a=0;a<=2;a=a+0.2)
        {
            for (int k = 1; k <=6 ; k++) {
                r[k]=Math.pow(7,a)-Math.cos(k);
                res=res+r[k];
                if(k==6)
                {
                    y[i]=res;
                    res=0;
                }
            }
            i++;
        }
        for (int j = 0; j < 11; j++) {
            System.out.printf("При a=%6.2f Сумма y=%g",j*0.2,y[j]);
            System.out.println();
        }
    }

    public static void step2()
    {
        double a;
        double b;
        for (double x = -5.5; x < 2; x = x + 0.5) {
            if (x / 2 > -2 && x / 2 <= -1) {
                b = sin(x * x);
            } else if (x / 2 > -1 && x / 2 < 0.2) {
                b = cos(x * x);
            } else if (x / 2 == 0.2) {
                b = 1 / tan(x * x);
            } else {
                System.out.println("вычисления не определены");
                continue;
            }
            a = log10(abs(b + 2.74));
            System.out.printf("При x/2 =%4.2f a =%16.12f\n", x / 2, a);
        }
    }
}
