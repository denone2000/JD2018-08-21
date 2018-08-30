package by.it.galushka.jd01_03;

public class Helper {

    /**
     * findMin находит минимальное значение массива;
     * @param arr входящий массив;
     * @return минимальное значение массива;
     */
    static double findMin(double[] arr) {
        double min = Integer.MAX_VALUE;
        for (double element : arr) {
            if (element < min) min = element;
        }
        return min;
    }

    /**
     * findMax находит максимальное значение массива;
     * @param arr входящий массив;
     * @return максимальное значение массива;
     */
    static double findMax(double[] arr) {
        double max = Integer.MIN_VALUE;
        for (double element : arr) {
            if (element > max) max = element;
        }
        return max;
    }

    /**
     * sort пузырьковая сортировка;
     * @param arr входящий массив;
     */
    public static void sort(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                double tmp;
                if (arr[j] > arr[j + 1]) {
                    tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    /**
     * mul умножение матрицы на вектор;
     * @param matrix входящая матрица;
     * @param vector входящий вектор;
     * @return результат умножения матрицы на вектор;
     */
    static double[] mul(double[][] matrix, double[] vector) {
        double[] res=new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                res[i] = res[i] + matrix[i][j] * vector[j];
            }
        }
        return res;
    }

    /**
     * mul умножение матрицы на матрицу;
     * @param matrixLeft входящая матрица 1;
     * @param matrixRight входящая матрица 2;
     * @return результат умножения матрицы 1 на матрицу 2;
     */
    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] res=new double[matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    res[i][j] = res [i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }
            }
        }
        return res;
    }
}
