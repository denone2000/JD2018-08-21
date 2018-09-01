package by.it.akhmelev.jd01_03;

public class InOut {

    public static double[ ] getArray(String line){
        String[] strVar = line.trim().split(" ");
        double[ ] res=new double[strVar.length];
        for (int i = 0; i < strVar.length; i++) {
            res[i]=Double.parseDouble(strVar[i]);
        }
        return res;
    }


    static void printArray(double[ ] arr){
        for (double element : arr) {
            System.out.print(element+" ");
        }
        System.out.println();
    }

    public static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.3f ",name,i,arr[i]);
            if ((i+1)%columnCount==0)
                System.out.println();
        }
        System.out.println();
    }



}
