package by.it.kuzmich.JD_01_03;

public class InOut {

    public static double[ ] getArray(String line){
        String[] strArray = line.split(" "); //Присвоили массив сторк
        double [] res = new double[strArray.length];
        for (int i = 0; i < strArray.length; i++) {
            res[i] = Double.parseDouble(strArray[i]);
        }
        return res;

    }
    static void printArray(double[] arr){
        for (double element : arr) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

   public static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d]=%-10.4f",name,i,arr[i]);
            if ((i+1)%columnCount==0 || i+1==arr.length)
                System.out.println();
            
        }
    }



}
