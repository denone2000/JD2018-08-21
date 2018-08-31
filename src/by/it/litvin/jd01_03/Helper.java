package by.it.litvin.jd01_03;

public class Helper {

    static double findMin(double[] arr) {
        double min = arr[0];
        if (0 == arr.length) {
            return Double.MIN_VALUE;
        } else {
            for (int i = 0; i < arr.length; i++) {
                if (min > arr[i]) {
                    min = arr[i];
                }

            }
            return min;
        }
    }


    static double findMax(double[] arr) {
        double max = arr[0];
        if (0 == arr.length) {
            return Double.MAX_VALUE;
        } else {

            for (int i = 0; i < arr.length; i++) {
                if (max < arr[i]) {
                    max = arr[i];
                }
            }
            return max;
        }

    }

       /** static void sort(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            double min = arr[i];
            double min1 = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    min1 = j;
                }

            }
            if (i != min1) {
                double tmp = arr[i];
                arr[i] = arr[(int) min1];
                arr[(int) min1] = tmp;
            }


        }
    }*/


    static double[] mul(double[][] matrix, double[] vector) {
        double[] z = new double[matrix.length];
        for (int i = 0; i < matrix.length; i++)
            for (int j = 0; j < vector.length; j++)
                z[i] = z[i] + matrix[i][j] * vector[j];
        return z;

    }

    public static void sort(double[] arr){
        for (int last=arr.length-1;last>0;last--){
            for (int j=0; j<last; j++){
                if (arr[j]>arr[j+1]){
                    double tmp = arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }

        }
    }

    static double[ ][ ] mul(double[ ][ ] matrixLeft, double[ ][ ] matrixRight){
        double[][] z = new double[matrixLeft.length][matrixRight[0].length ];
        for (int i = 0; i < matrixLeft.length; i++)
            for (int j = 0; j < matrixRight[0].length; j++)
                for (int k = 0; k <matrixRight.length ; k++)
                z[i][j] = z[i][j] + matrixLeft[i][k] * matrixRight[k][j];
        return z;

    }
   }
















