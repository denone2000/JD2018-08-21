package by.it.korzik.jd01.jd01_03;

public class Helper {
     static double findMin(double[] arr) {
        double min = Double.MAX_VALUE;
        for (double v : arr) {
            if (min > v) {
                min = v;
            }
        }
        return min;
    }

     static double findMax(double[] arr) {
        double max = Double.MIN_VALUE;
        for (double v : arr) {
            if (max < v) {
                max = v;
            }
        }
        return max;
    }

    public static void sort(double[] arr) {
        double n;
        for (int i = arr.length-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    n = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = n;
                }
            }
        }
        for (double v : arr) {
            System.out.print(v+" ");
        }
        System.out.println();
    }

    public static double[] mul(double[][] matrix, double[] vector) {
        double[] mul = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < vector.length; j++) {
                mul[i] = mul[i] + matrix[i][j] * vector[j];
            }
        }
        return mul;
    }

    public static double[][] mul(double[][] matrixLeft, double[][] matrixRight) {
        double[][] mul = new double[matrixLeft.length][matrixRight[0].length];
        for (int b = 0; b < matrixLeft.length; b++) {
            for (int c = 0; c < matrixRight[0].length; c++) {
                for (int a = 0; a < matrixRight.length; a++) {
                    mul[b][c] = mul[b][c] + matrixLeft[b][a] * matrixRight[a][c];
                }
            }
        }
        return mul;
    }
}

