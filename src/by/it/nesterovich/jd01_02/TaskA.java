package by.it.nesterovich.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {

        int[] mas = new int[10];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }

        step1(mas);
        step2(mas);
        step3(mas);

    }

    static void step1(int[] mas) {

        int min = mas[0];
        int max = mas[0];

        for (int element : mas) {
            if (element < min) min = element;
            if (element > max) max = element;
        }

        System.out.println(min + " " + max);
    }

    static void step2(int[] mas) {

        double avg = 0;

        for (int element : mas) {
            avg = avg + element;
        }

        avg = avg / mas.length;

        for (int element : mas) {
            if (element < avg) {
                System.out.println(element);
            }
        }
    }

    static void step3(int[] mas) {

        int min = mas[0];

        for (int element : mas) {
            if (element < min) min = element;
        }
        for (int i = mas.length - 1; i >=0 ; i--) {
            if (mas[i] == min) {
                System.out.print(i+" ");
            }
        }
    }

}
