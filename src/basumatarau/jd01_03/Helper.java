package basumatarau.jd01_03;

public class Helper {
    /** the method looks up the min value in the array on the input and returns it
     * @param arr - array of double values
     */
    public static double findMax (double[] arr){
        double result = arr[0];

        for (double doubleItem : arr) {
            if (doubleItem > result) result = doubleItem;
        }

        return result;    
    }

    /** the method looks up the min value in the array on the input and returns it
     * @param arr - array of double values
     */

    public static double findMin (double[] arr){
        double result = arr[0];

        for (double doubleItem : arr) {
            if (result > doubleItem) result = doubleItem;
        }

        return result;
    }
    /* bubble sorting
    public static void sort(double[] arr){
        int sorted = 0;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length -1 - sorted; j++) {
                if (arr[j] > arr[j+1]){
                    double buff = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = buff;
                }
            }
            sorted++;
        }
    }
    */

    /** quick sorting wrappring method
     * @param arr - array of double values to be sorted;
     * */
    public static void sort(double[] arr){
        quickSort(arr, 0, arr.length -1);
    }
    /** the method implements quick sorting algorithm on subarrays of double values recursively
    * @param arr - input array of double values containing the subarray to be sorted
    * @param lowerInd - lower index of the subarray to be sorted
    * @param upperInd - upper index of the subarray to be sorted
    * */
    public static void quickSort (double[] arr, int lowerInd, int upperInd){
        if(lowerInd >= upperInd) return;

        int partition = partition(arr, lowerInd, upperInd);

        quickSort(arr, lowerInd, partition -1);
        quickSort(arr, partition +1, upperInd);
    }
    /** the method rearranges the subarray on the input so that the last item of the array is placed between lower or equal items on the left (with lower indices) and larger values on the righ (with higher indices)
    * @param arr - input array
    * @param lowerInd - lower index of the subarray to be rearranged
    * @param higherInd - upper index of the subarray to be rearranged
    * @return partition - the index of the element that has been sorted relative to the rest of the array
     * **/
    public static int partition(double[] arr, int lowerInd, int higherInd){
        double pivot = arr[higherInd];
        int lower = lowerInd - 1;

        for (int i = lowerInd; i < higherInd; i++) {
            if (arr[i] <= pivot){
                lower++;
                double buff = arr[i];
                arr[i] = arr[lower];
                arr[lower] = buff;
            }
        }
        arr[higherInd] = arr[lower + 1];
        arr[lower + 1] = pivot;

        return lower + 1;
    }
    /** the method returns an instance of multipliccation of a matrix (lefthand val) of double values and a vector of double values
    * @param matrix - matrix of double values
    * @param vector - vector of double values
    * */
    public static double[] mul(double[][] matrix, double[] vector){

        double[] result = new double[matrix.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = 0;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                result[i] += matrix[i][j]*vector[j];
            }
        }

        return result;
    }
    /** the method returns the result of multipliccation of two matrices of double values
     * @param matrixLeft - matrix (lefthand cofactor) of double values
     * @param matrixRight - matrix (righthand cofactor) of double values
     * */
    public static double[][] mul(double[][] matrixLeft, double[][] matrixRight){
        double[][] result = new double[matrixLeft.length][matrixRight[0].length];

        for (double[] doubles : result) {
            for (double val : doubles) {
                val = 0;
            }
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                for (int k = 0; k < matrixRight.length; k++) {
                    result[i][j] += matrixLeft[i][k]*matrixRight[k][j];
                }
            }
        }

        return result;
    }
}
