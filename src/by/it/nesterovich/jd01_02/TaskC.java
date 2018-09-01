package by.it.nesterovich.jd01_02;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mas = step1(n);

        int sum = step2(mas);
        System.out.println(sum);

        step3(mas);
    }

    static int[][] step1(int n) {

        int countMax = 0;
        int countMin = 0;
        int[][] mas = new int[n][n];

        do {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) (Math.random() * (2 * n + 1)) - n;
                    if (mas[i][j] == n) {
                        countMax++;
                    }
                    if (mas[i][j] == -n) {
                        countMin++;
                    }
                }
            }
        }
        while (countMax < 1 & countMin < 1);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
        return mas;
    }

    static int step2(int[][] mas) {

        int sum = 0;
        int[] index = new int[2];

        for (int i = 0; i < mas.length; i++) {
            int k = 0;
            for (int j = 0; j < mas.length & k < 2; j++) {
                if (mas[i][j] > 0) {
                    index[k] = j;
                    k++;
                }
                if (k == 2) {
                    for (int l = index[0] + 1; l < index[1]; l++) {
                        sum = sum + mas[i][l];
                    }
                }
            }
        }
        return sum;
    }

    static int[][] step3(int[][] mas) {

        int max = mas[0][0];

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > max) {
                    max = mas[i][j];
                }
            }
        }

        ArrayList<Integer> rows = new ArrayList<>();
        ArrayList<Integer> columns = new ArrayList<>();

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] == max) {
                    if (rows.contains(i)) {
                    } else {
                        rows.add(i);
                    }
                    if (columns.contains(j)) {
                    } else {
                        columns.add(j);
                    }
                }
            }
        }

        int rowsNewMas = mas.length - rows.size();
        int columnsNewMas = mas.length - columns.size();
        int[][] newMas = new int[rowsNewMas][columnsNewMas];
        int countColumnsNewMas = 0;
        int countRowsNewMas = 0;

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (!rows.contains(i) & !columns.contains(j)) {
                    if (countColumnsNewMas == columnsNewMas) {
                        countColumnsNewMas = 0;
                        countRowsNewMas++;
                    }
                    newMas[countRowsNewMas][countColumnsNewMas] = mas[i][j];
                    countColumnsNewMas++;
                }
            }
        }

        for (int k = 0; k < newMas.length; k++) {
            for (int m = 0; m < newMas[k].length; m++) {
                System.out.print(newMas[k][m] + " ");
            }
            System.out.println();
        }

        return newMas;
    }
}
