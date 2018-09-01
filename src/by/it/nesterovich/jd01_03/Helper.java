package by.it.nesterovich.jd01_03;

import java.util.Arrays;

/**
 * Класс для задания уровня В;
 *
 * @author Нестерович;
 * @version 1.0;
 */
public class Helper {

    /**
     * Метод для поиска минимального значения в одномерном массиве;
     *
     * @param arr - одномерный массив типа double;
     * @return минимальное число;
     */
    static double findMin(double[] arr) {
        double min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        return min;
    }

    /**
     * Метод для поиска максимального значения в одномерном массиве;
     *
     * @param arr - одномерный массив типа double;
     * @return максимальное число;
     */
    static double findMax(double[] arr) {
        double max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    /**
     * Метод для сортировки массива;
     *
     * @param arr - одномерный массив;
     */
    public static void sort(double[] arr) {

        quickSort(arr,0,arr.length-1);
    }
    public static void quickSort(double[] array, int leftIndex,int rightIndex){

        if (leftIndex >= rightIndex) {
            return;
        }

        int i = leftIndex;
        int j = rightIndex;
        //int middleIndex = i - (i - j) / 2;
        int middleIndex = (i + j) / 2;
        while (i < j) {
            while (i < middleIndex && array[i] <= array[middleIndex]) {
                i++;
            }
            while (j > middleIndex && array[j] >= array[middleIndex]) {
                j--;
            }
            if (i < j) {
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == middleIndex) {
                    middleIndex = j;
                } else if (j == middleIndex) {
                    middleIndex = i;
                }
            }
        }
        quickSort(array, leftIndex, middleIndex);
        quickSort(array, middleIndex + 1, rightIndex);
    }

    /**
     * Метод для умножения матрицы на вектор;
     *
     * @param matrix - матрица типа double;
     * @param vector - вектор типа double;
     * @return результат умножения матрицы на вектор;
     */
    static double[] mul(double[][] matrix, double[] vector) {

        double[] result = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            double multiplication = 0;
            for (int j = 0; j < vector.length; j++) {
                multiplication = multiplication + matrix[i][j] * vector[j];
            }
            result[i] = result[i] + multiplication;
        }
        return result;
    }

    /**
     * Метод для умножения матрицы на матрицу;
     *
     * @param matrixLeft  - матрица типа double;
     * @param matrixRight - матрица типа double;
     * @return результат умножения матрицы на матрицу;
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {

        double[][] result = new double[matrixLeft.length][matrixRight[0].length];

        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                double sum = 0;
                for (int k = 0; k < matrixLeft[i].length; k++) {
                    sum = sum + matrixLeft[i][k] * matrixRight[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }
}
