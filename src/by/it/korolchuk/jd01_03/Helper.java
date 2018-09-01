package by.it.korolchuk.jd01_03;

import java.util.Arrays;

public class Helper {
    /**
     *Find min for array DOUBLE
     * @param arr - one-dimensional array
     * @return - min
     */
    static double findMin(double[ ] arr) {

        double[] tmp  = Arrays.copyOf(arr, arr.length);
            Arrays.sort(tmp);
        return tmp[0];
    }

    /**
     * Find min for array DOUBLE
     * @param arr - one-dimensional array
     * @return - max
     */
    static double findMax(double[ ] arr) {
        double max = arr[0];
        for (double element : arr) {
            if (max < element)
                max = element;
        }
        System.out.println(max);
        return max;
    }

    /**
     * Sorting array DOUBLE from min to max
     * @param arr - one-dimensional array
     */
    public static void sort(double[ ] arr) {
        for (int last =  arr.length-1; last > 0; last--) {
            for (int j = 0; j < last; j++) {
                if (arr[j] > arr[j +1]){
                    double tmp = arr[j];
                    arr[j] = arr[j +1];
                    arr[j +1] = tmp;
                }
            }
        }
    }

    /**
     *matrix DOUBLE to vector DOUBLE multiplication
     * @param matrix - simple matrix
     * @param vector - one-dimensional array
     * @return - result matrix
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] mul = new double[matrix.length];
        for (int i = 0; i <  matrix.length; i++) {
            for (int j = 0; j <  matrix[i].length; j++) {
                mul[i] += matrix[i][j] * vector[j];
            }
        }
        return mul;
    }

    /**
     *Two matrix DOUBLE multiplication
     * @param matrixLeft - matrix 1
     * @param matrixRight - matrix 2
     * @return - result matrix
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {

        int m = matrixLeft.length;
        int n = matrixRight[0].length;
        int o = matrixRight.length;
        double[][] matrixResult = new double[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <  n; j++) {
                for (int k = 0; k < o; k++) {
                    matrixResult[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        for (int i = 0; i < matrixResult.length; i++) {
            for (int j = 0; j < matrixResult[0].length ; j++) {
                System.out.printf("%4.1f ", matrixResult[i][j]);
            }
        }
        return matrixResult;
    }
}
