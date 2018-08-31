package by.it.voinilo.jd01_03;

public class Helper {
    static double findMin(double[] arr) {
        if (0 == arr.length) {
            return Integer.MIN_VALUE;
        } else {
            double min = arr[0];
            for (double m : arr) {
                if (min > m) min = m;
            }
            return min;

        }


    }

    static double findMax(double[] arr) {
        if (0 == arr.length) {
            return Integer.MAX_VALUE;
        } else {
            double max = arr[0];
            for (double m : arr) {
                if (max < m) max = m;
            }
            return max;

        }
    }

    static double[] sort(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    double buff;
                    buff = arr[j];
                    arr[j] = arr[i];
                    arr[i] = buff;
                }

            }
        }
        return arr;

    }


    static double[] mul(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                z[i] = z[i] + matrix[i][j] * vector[j];

            }
        }
        return z;
    }

    static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] w = new double[matrixLeft.length][];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    w[i][j] = w[i][j] + matrixLeft[i][k] * matrixRight[k][j];
                }


            }
        }
        return w;
    }
}
