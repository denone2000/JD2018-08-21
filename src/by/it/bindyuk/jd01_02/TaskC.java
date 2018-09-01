package by.it.bindyuk.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите n: ");
        int n = scanner.nextInt();
        int[][] mas = new int[n][n];
        step1(n);
    }

    public static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        boolean found1 = false;
        boolean found2 = false;
        do {
            found1 = false;
            found2 = false;
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < mas[0].length; j++) {
                    mas[i][j] = (int) (Math.random() * (n + n + 1)) - n;
                    if (mas[i][j] == -n) {
                        found1 = true;
                    }

                    if (mas[i][j] == n) {
                        found2 = true;
                    }
                }
            }
        }
        while (!found1 || !found2);
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
        return mas;
    }
}








