package by.it.korolchuk.jd01_02;

        import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        step1(n);
        int[][] arr = step1(n);
        step3(arr);
    }

    private static int[][] step1(int n) {
        int[][] mas = new int[n][n];
        int i, j;

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                mas[i][j] = -n + (int) (Math.random() * (2 * n + 1));
            }
        }

        for (i = 0; i < n; i++) {
            for (j = 0; j < n; j++) {
                System.out.print(mas[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        return mas;
    }


    static int[][] step3(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int[] row : arr) {
            for (int element : row) {
                if (max < element)
                    max = element;
            }
        }
        //buid markers
        boolean[] delRow = new boolean[arr.length];
        boolean[] delCol = new boolean[arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == max) {
                    delCol[j] = true;
                    delRow[i] = true;
                }
            }
        }
        //calc size result
        int rowCount = 0;
        for (boolean b : delRow) {
            if (!b) rowCount++;
        }

        int colCount = 0;
        for (boolean b : delCol) {
            if (!b) colCount++;
        }
        int[][] res = new int[rowCount][colCount];

        //fill res
        int ir = 0;
        for (int i = 0; i < arr.length; i++) {
            if (!delRow[i]) {
                int jc = 0;
                for (int j = 0; j < arr[i].length; j++) {
                    if (!delCol[j]) {
                        res[ir][jc] = arr[i][j];
                        jc++;
                    }
                }
                ir++;
            }
        }
        return res;
    }
}
