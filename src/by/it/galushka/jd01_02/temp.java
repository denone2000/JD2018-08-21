package by.it.galushka.jd01_02;

import java.util.Scanner;

public class temp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        step1(n);
    }

    static void step1(int n) {
        int[][] mas = new int[n][n];
        int min = mas[0][0];
        int max = mas[0][0];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = (int) (Math.random() * (n * 2 + 2) - (n + 1));
                if (mas[i][j] < min) min = mas[i][j];
                if (mas[i][j] > max) max = mas[i][j];
                if (min == -n && max == n) break;
            }
            if (min == -n && max == n) break;
        }
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(mas[i][j] + " ");
                if ((j+1) % n == 0){
                    System.out.println(" ");
                }
            }
        }
    }
}
