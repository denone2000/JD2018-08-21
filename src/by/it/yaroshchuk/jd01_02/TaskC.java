package by.it.yaroshchuk.jd01_02;

import java.util.Scanner;


public class TaskC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] mas = step1(n);
        int sum = step2(mas);
        int[][] newMas = step3(mas);
    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        boolean checkMin = false;
        boolean checkMax = true;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mas[i][j] = (int) Math.round((Math.random() * (n * 2) - n));
                if (mas[i][j] == -n)
                    checkMin = true;
                if (mas[i][j] == n)
                    checkMax = true;
            }
        }

        if (checkMin == true && checkMax == true) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.print(mas[i][j] + " ");
                }
                System.out.println();
            }
        } else
            step1(n);


        return mas;
    }

    private static int step2(int[][] mas) {
        int first = -1, last = -1;
        int sum = 0;

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                if (mas[i][j] > 0) {
                    if (first > -1)
                        last = j;
                    else
                        first = j;
                }
                if (first > -1 && last > -1) break;
            }
            if ((last + 1) - (first + 1) > 1) {
                for (int j = first + 1; j < last; j++)
                    sum += mas[i][j];
            }
            first = -1;
            last = -1;
        }
        System.out.println(sum + " ");
        return sum;
    }

    private static int[][] step3(int[][] mas) {
        int max = Integer.MIN_VALUE;
        for (int[] row : mas) {
            for (int element : row) {
                if(max < element)
                    max = element;
            }
        }

        boolean[] delRow = new boolean[mas.length];
        boolean[] delCol = new boolean[mas[0].length];

        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max){
                    delCol[j] = true;
                    delRow[i] = true;
                }
            }
        }

        int rowCount = 0;
        for (boolean b : delRow) {
            if (!b) rowCount++;
        }
        int colCount = 0;
        for (boolean b : delCol) {
            if (!b) colCount++;
        }

        int [][] res = new int[rowCount][colCount];

        int ir = 0;
        for (int i = 0; i < mas.length; i++) {
            if(!delRow[i]) {
                int jc = 0;
                for (int j = 0; j < mas[i].length; j++) {
                    if (!delCol[j])
                        res[ir][jc] = mas[i][j];
                    jc++;
                }
                ir++;
            }
        }
        return res;
    }
}

