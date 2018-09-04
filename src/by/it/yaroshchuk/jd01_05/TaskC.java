package by.it.yaroshchuk.jd01_05;

public class TaskC {
    public static void main(String[] args) {
        step1();
    }

    public static void step1(){
        double[] z = new double[28];
        int i = 0;
        int counter = 0;
        for (double x = 5.33; x <= 9; x = x + ((9 - 5.33)/28)) {
            z[i] = Math.cbrt(x*x + 4.5);
            if(z[i] > 3.5)
                counter++;
            i++;
        }

        System.out.println("Массив А[] ");
        printArray(z, "A", 5);
        System.out.println();

        double[] newZ = new double [counter];
        int k = 0;
        for (int j = 0; j < z.length; j++) {
            if(z[j] > 3.5) {
                newZ[k] = z[j];
                k++;
            }
        }

        System.out.println("Массив B[] из элементов массива A > 3.5");
        printArray(newZ, "B", 5);
    }

    public static void printArray(double[ ] arr, String name, int columnCount){
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[% -3d] = %-10.5f ", name, i, arr[i]);
            if((i + 1) %columnCount == 0)
                System.out.println();
        }
        System.out.println();
    }
}


