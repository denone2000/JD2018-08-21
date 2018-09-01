package by.it.korzik.jd01_03;


public class InOut {
    public static double[ ] getArray(String line){
        String[] strArr = line.trim().split(" ");
        double[] res = new double[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            res[i] = Double.parseDouble(strArr[i]);
        }
        return res;
    }
    public static void printArray(double[ ] arr){
        for (double v : arr) {
            System.out.print(v+" ");
        }
        System.out.println();
    }
    public static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
        if (i%columnCount==0){
            System.out.println();
        }
        System.out.printf("%s[% -3d]=%-10.3f", name, i,arr[i]);
        }
        System.out.println();
    }
}
