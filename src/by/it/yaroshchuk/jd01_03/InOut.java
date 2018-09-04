package by.it.yaroshchuk.jd01_03;

/**
 * Created by user on 25.08.2018.
 */
public class InOut {

    public static double[] getArray(String line){
        String[] strVar = line.trim().split(" ");
        double[] res = new double [strVar.length];
        for (int i = 0; i < strVar.length; i++) {
            res[i] = Double.parseDouble(strVar[i]);
        }
        return res;
    }

    static void printArray(double[ ] arr){
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    public static void printArray(double[ ] arr, String name, int columnCount){
        int counter = 1;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f ", name, i, arr[i]);
            if((i + 1) %columnCount == 0)
                System.out.println();
        }
        System.out.println();
    }

    static void printArray(double[][] arr){
        for (double[] element : arr) {
            for (double value : element) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
