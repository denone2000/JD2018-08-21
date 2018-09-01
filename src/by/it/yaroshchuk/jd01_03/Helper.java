package by.it.yaroshchuk.jd01_03;

/**
 * Created by user on 25.08.2018.
 */
public class Helper {
    static double findMin(double[ ] arr){
        double min = arr[0];
        for (double element : arr) {
            if(element < min)
                min = element;
        }
        return min;
    }

    static double findMax(double[ ] arr){
        double max = arr[0];
        for (double element : arr) {
            if(element > max)
                max = element;
        }
        return max;
    }

    public static void sort(double[] arr){
        boolean swap;
        int last = arr.length - 1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if(arr[i] > arr[i+1]){
                    double buffer = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buffer;
                    swap = true;
                }
            }
            last--;
        } while(swap);

        InOut.printArray(arr);
    }

    static double[ ] mul(double[ ][ ] matrix, double[ ] vector){
        double [] matrixMulVector = new double [matrix[0].length];
        for (int i = 0; i < vector.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                matrixMulVector[i] += matrix[i][j] * vector[j];
            }
        }
        return matrixMulVector;
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] matrixMulMatrix = new double [matrixLeft.length][matrixRight[0].length];
        for (int i = 0; i < matrixLeft.length; i++) {
            for (int j = 0; j < matrixRight[0].length; j++) {
                for (int k = 0; k < matrixLeft[0].length; k++) {
                    matrixMulMatrix[i][j] += matrixLeft[i][k] * matrixRight[k][j];
                }

            }
        }
        return matrixMulMatrix;
    }
}
