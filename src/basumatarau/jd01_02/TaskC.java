package basumatarau.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine().trim());

        int [][] matrix = step1(n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.print('\n');
        }
        System.out.println(step2(matrix));
        System.out.println(" ");

        int [][] reducedMatrix = step3(matrix);

        System.out.println(" ");

        for (int i = 0; i < reducedMatrix.length; i++) {
            for (int j = 0; j < reducedMatrix[0].length; j++) {
                System.out.print(reducedMatrix[i][j] + " ");
            }
            System.out.print('\n');
        }

    }

    public static int [][] step1(int n){
        int [][] matrix = new int[n][n];
        boolean hasMaxVal=false, hasMinVal=false;

        while (!(hasMaxVal && hasMinVal)) {
            hasMaxVal=false;hasMinVal=false;
            for (int i = 0; i < matrix.length; i++) {
                for (int j=0; j < matrix[i].length; j++) {
                    matrix[i][j] = (int) ( (n + 1)*(1.0 - 2.0*(Math.random())) );
                    if (matrix[i][j] == n) hasMaxVal = true;
                    if (matrix[i][j] == (int)(0 - n)) hasMinVal = true;
                }
            }
        };
        return matrix;
    }

    public static int step2(int[][] matrix){
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            int indexFirst = -1;
            int indexSecond = -1;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] >= 0 && indexFirst == -1){
                    indexFirst = j;
                } else if (matrix[i][j] >= 0 && indexFirst != -1 && indexSecond == -1) {
                    indexSecond = j;
                }
                else continue;
            }
            if ( ((indexSecond - indexFirst) > 1) && indexFirst != -1 && indexSecond != -1 ) {
                for (int k = indexFirst+1; k < indexSecond; k++) {
                    sum+=matrix[i][k];
                }
            }
        }

        System.out.println(sum);
        return sum;
    }

    static int[][] step3(int[][] matrix){
        int maxVal = matrix[0][0];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxVal < matrix[i][j]){
                    maxVal = matrix[i][j];
                }
            }
        }

        int maxCounter = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxVal == matrix[i][j]){
                    maxCounter++;
                }
            }
        }

        boolean[] trueRows = new boolean[matrix.length];
        boolean[] trueCol = new boolean[matrix[0].length];

        for (int i = 0; i < trueRows.length; i++) {
            trueRows[i] = true;
        }
        for (int i = 0; i < trueCol.length; i++) {
            trueCol[i] = true;
        }

        for (int i = 0; i < matrix.length; i++) {
           for (int j = 0; j < matrix[i].length; j++) {
               if (matrix[i][j] == maxVal){
                    trueRows[i] = false;
                    trueCol[j] = false;
               }
           }
        }

        int dimRows = 0;
        int dimCol = 0;
        for (boolean flag: trueRows) {
            if (flag) dimRows++;
        }
        for (boolean flag: trueCol) {
            if (flag) dimCol++;
        }

        int[][] amendedMatrix = new int[dimRows][dimCol];

        int amendedRow = 0;
        int amendedCol = 0;
        for (int i = 0; i < matrix.length; i++) {
            if (trueRows[i]) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (trueCol[j]){
                        amendedMatrix[amendedRow][amendedCol] = matrix[i][j];
                        amendedCol++;
                    }
                }
                amendedRow++;
                amendedCol=0;
            }
        }

        for (int i = 0; i < amendedMatrix.length; i++) {
            for (int j = 0; j < amendedMatrix[i].length; j++) {
                System.out.print(amendedMatrix[i][j] + " ");
            }
            System.out.print('\n');
        }

        return amendedMatrix;
    }
}
