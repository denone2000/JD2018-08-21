package by.it.bindyuk.jd01_03;

import java.util.Arrays;

public class Helper {
    /**
     * @param arr входной одноменый массив для поиска минимума
     * @return возвращает число типа double минимальное в миссиве
     */
    public static double findMin(double[] arr) {
        double min = arr[0];
        if (0 == arr.length) {
            return Double.MIN_VALUE;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                }
            }
        }
        return min;
    }

    /**
     * @param arr входной массив
     * @return возвращает число double, максимальное в массиве
     */
    public static double findMax(double[] arr) {
       // Arrays.copyOf(arr, arr.length)
        double max = arr[0];
        if (0 == arr.length) {
            return Double.MAX_VALUE;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
        }
        return max;
    }

    /**
     * @param arr входной массив для сортироовки
     */
    public static void sort(double[] arr) {
        boolean swap;
        double last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                double buff = 0;
                if (arr[i] > arr[i + 1]) {
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                    swap = true;
                }
            }
            last--;
        } while (swap);
    }

    /**
     * @param matrix входная матрица
     * @param vector входной вектор
     * @return полученная матрица
     */
    public static double[] mul(double[][] matrix, double[] vector) {
        double[] res = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                res[i] += (matrix[i][j] * vector[j]);
            }
            System.out.print(res[i] + " ");
            System.out.println();
        }

        return res;
    }

    /**
     * @param matrixLeft  первая матрица(слева)
     * @param matrixRight вторая матрица(справа)
     * @return перемноженная матрица
     */
    public static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] res = new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    res[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
        return res;
    }
}


