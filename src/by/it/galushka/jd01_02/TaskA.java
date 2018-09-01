package by.it.galushka.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    static void step1(int[] mas) {
        int min=mas[0];
        int max=mas[0];
        for (int ma : mas) {
            if (min > ma) min = ma;
            if (max < ma) max = ma;
        }
        System.out.println(min + " " + max);
    }

    static void step2(int[] mas) {
        double avg=0;
        for (int ma : mas) {
            avg = avg + ma;
        }
        avg = avg/mas.length;
        System.out.println(avg);
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < avg)
                System.out.print(mas[i]+" ");
        }
        System.out.println(" ");
    }

    static void step3(int[] mas) {
        int min = mas[0];
        for (int element : mas) {
            if (element < min) min = element;
        }
        for (int i=mas.length-1; i >= 0; i--) {
            if (mas[i] == min) {
                System.out.print(i+" ");
            }
        }
    }
}


