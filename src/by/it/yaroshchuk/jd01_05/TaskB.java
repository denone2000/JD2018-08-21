package by.it.yaroshchuk.jd01_05;

import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }

    public static void step1(){

        for (double a = 0; a <= 2 ; a = a + 0.2) {
            double y = 0;
            for ( int x = 1; x <= 6 ; x++) {
                y += pow(7, a) - cos(x);
            }
            System.out.printf("При а=%1.2f Сумма y = %f\n", a, y);;
        }
    }

    public static void step2(){
        for (double x = -6 + 0.5; x < 2; x = x + 0.5) {
            double b = 0;
            double a;
            if(x/2 > -2 && x/2 <= -1){
                b = sin(x * x);
            }else if(x/2 > -1 && x/2 < 0.2){
                cos(x * x);
            }else if(x/2 == 0.2){
                b = 1 / tan(x * x);
            }else{
                System.out.printf("При x/2=%1.2f вычисления не определены\n", (x/2));
            }
            a = log10(abs(b + 2.74));
            System.out.printf("При x/2=%1.2f a = %f\n", (x / 2), a);
        }
    }
}
