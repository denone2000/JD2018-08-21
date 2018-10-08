package by.it.korzik.jd01.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        int n;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        int[][] mas = step1(n);
        step2(mas);
        step3(mas);
    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        int x = 0;
        while (x < 1) {
            boolean isMin = true, isMax = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    mas[i][j] = (int) (Math.random() * (n + n + 1) + (-n) - 0.5);
                    if (mas[i][j] == (-n)) {
                        isMin = false;
                    }
                    if (mas[i][j] == n) {
                        isMax = false;
                    }
                }
            }
            if (isMin || isMax) {
                continue;
            }
            x++;
        }
        return mas;
    }

    private static int step2(int[][] mas) {
        int sum = 0, x;
        for (int[] var : mas) {
            x = 0;
            for (int i : var) {
                if (x > 0) {
                    if (i > 0) {
                        x++;
                    }
                }
                if (x == 1) {
                    sum = sum + i;
                }
                if (i > 0) {
                    x++;
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    private static int[][] step3(int[][] mas) {
        int max = Integer.MIN_VALUE;
        for (int[] ma : mas) {
            for (int i : ma) {
                if (max < i) {
                    max = i;
                }
            }
        }
        boolean[] delRow = new boolean[mas.length];
        boolean[] delCol = new boolean[mas[0].length];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] == max) ;
                {
                    delCol[j] = true;
                    delRow[i] = true;
                }

            }
        }
        int rowCount = 0, colCount = 0;
        for (boolean b : delRow) {
            if (!b) {
                rowCount++;
            }
        }
        for (boolean b : delCol) {
            if (!b) {
                colCount++;
            }
        }
        int[][] res = new int[rowCount][colCount];
        int ir=0;
        for (int i = 0; i < mas.length; i++) {
            if (!delRow[i]){
                int jc=0;
            for (int j = 0; j < mas[i].length; j++) {
                if (!delCol[j]) ;
                {
                    res[ir][jc]=mas[i][j];
                    jc++;
                }

            }
            ir++;
        }
        }
        return res;
    }

}
