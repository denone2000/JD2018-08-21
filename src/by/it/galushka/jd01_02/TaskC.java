package by.it.galushka.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();

        int[][] mas = step1(n);

        int t = step2(mas);

        int[][] matrix = step3(mas);
    }

    static int[][] step1(int n){
        int[][] mas = new int[n][n];
        int min = mas[0][0];
        int max = mas[0][0];
        for (int k = 0; ;k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) (Math.random() * (n * 2 + 2) - (n + 1));
                    if (mas[i][j] < min) min = mas[i][j];
                    if (mas[i][j] > max) max = mas[i][j];
                }
            }
            if (min == -n && max == n) {
                break;
            }
        }
            for (int i = 0; i < n; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(mas[i][j] + " ");
                    if ((j+1) % n == 0){
                        System.out.println(" ");
                    }
                }
            }
        return mas;
    }

    static int step2(int [][] mas) {
        int t = 0;
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length-1; j++) {
                if (mas[i][j] >= 0) {
                    if (mas [i][j+1] < 0) {
                        for (int k = j + 1; mas[i][k] < 0; k++) {
                            t = t + mas[i][k];
                        }
                    }
                    else
                        break;
                }
            }
        }
        return t;
    }

    static int[][] step3(int[][] mas) {
        int[][] matrix = new int[mas.length][mas.length];
        return matrix;
    }
}
