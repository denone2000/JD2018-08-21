package basumatarau.jd01_03;

import java.util.Scanner;

public class InOut {

    public static void main(String[] args) {
        double [] arr = {1, 4, 5, 6, 7.5};

    }
    /** parses String val into an array of double values
    * @param str - Sting value to be parsed
    * */
    public static double[] getArray(String str){
        String[] strArr = str.trim().split(" ");
        double[] result = new double[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
            result[i] = Double.parseDouble(strArr[i]);
        }

        return result;
    }
    /** prints an array of double values on the inpunt into standard output
    * @param arr - an array of double values to be printed
    * */
    public static void printArray (double[] arr){
        for (double item: arr) {
            System.out.print( item + " ");
        }
        System.out.println(" ");
    }
    /** prints the array of double values into standard output, with formatting having been taken care of
     * @param arr - an array of double values to be printed
     * @param name - the name of the matrix to be printed
     * @param colNum - the max number of columns per line
     * */
    public static void printArray (double[] arr, String name, int colNum){
        if (arr.length == 0) return;

        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-4.1f ", name, i,  arr[i]);
            if ((i+1)%colNum == 0 || i+1 == arr.length){
                System.out.print('\n');
            }
        }
    }
}
