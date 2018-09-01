package by.it.basumatarau.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String [] args){
        Scanner scanner = new Scanner (System.in);

        int[] mas = new int[10];

        for (int i = 1; i < mas.length; i++) {
            mas[i]=scanner.nextInt();
        }

        step1(mas);
        step2(mas);
        int[] test = {-1, 22, 33, 44, 567, 567, 44, 33, 22, -1, 4, 4};
        step3(test);

    }

    static void step1 (int[] mas){
        int maxVal = mas[0];
        int minVal = mas[0];

        for (int i=0; i<mas.length; i++){
            if (maxVal<mas[i]){
                maxVal=mas[i];
            }
            if (minVal>mas[i]){
                minVal=mas[i];
            }
        }
        System.out.print(minVal + " " + maxVal);
    }

    static void step2 (int[] mas){
        double sum = 0.0;
        for (int i = 0; i < mas.length; i++) {
            sum = (double) (mas[i] + sum);
        }
        double average = sum/mas.length;

        for (int i = 0; i < mas.length; i++) {
            if (mas[i]<average) {
                System.out.print(mas[i] + " ");
            }
        }
    }

    static void step3 (int[] mas){
        int min = mas[mas.length-1];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i]<=min){
                min=mas[i];
            }
        }

        for (int i = mas.length-1; i >= 0; i--) {
            if (mas[i]==min){
                System.out.print(i + " ");
            }
        }
    }
}
