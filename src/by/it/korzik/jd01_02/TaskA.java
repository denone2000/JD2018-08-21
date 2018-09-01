package by.it.korzik.jd01_02;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        int[] mas = new int[10];
        Scanner scan = new Scanner(System.in);

        for (int a = 0; a < mas.length; a++) {
            mas[a] = scan.nextInt();
        }

        step1(mas);
        step2(mas);
        step3(mas);
    }

    static void step1(int[] mas) {
        int min = mas[0], max = mas[0];
        for (int m : mas) {
            if (min > m) {
                min = m;
            }
            if (max < m) {
                max = m;
            }
        }
        System.out.println(min + " " + max);
    }

    static void step2(int[] mas) {
     double avg = 0;
     double x = 0;
        for (int a : mas) {
            avg+=a;
        }
        avg=avg/mas.length;
        for (int i : mas) {
            if (i<avg){
                System.out.print(i);
            }
            System.out.println();
        }

    }

    static void step3(int[] mas) {
        int min = mas[0];
        for (int m : mas) {
            if (min > m) {
                min = m;
            }
        }
        for (int i = mas.length-1; i >=0; i--) {
            if (mas[i]==min){
                System.out.print(i + " ");
            }
        }
    }
}
