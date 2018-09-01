package by.it.galushka.jd01_05.taskC;

public class TaskC1 {
    public static double[] getArrayA(double[] array) {
        int i = 0;
        for (double x = 5.33; x <= 9; x = x + 0.1) {
            array[i] = Math.cbrt(x * x + 4.5);
            i++;
        }
        return array;
    }

    public static void printArrayA(double[] array) {
        for (int j = 0; j < array.length; j++) {
            System.out.printf("%c[% -3d] = %-10.5f", 'A', j, array[j]);
            if ((j + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n");
    }

    public static double[] getArrayB(double[] array) {
        int t = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5)
                t++;
        }
        double[] arrayB = new double[t];
        t =0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 3.5) {
                arrayB[t] = array[i];
                t++;
            }
        }
        return arrayB;
    }

    public static void printArrayB (double[] array) {
        for (int j = 0; j < array.length; j++) {
            System.out.printf("%c[% -3d] = %-10.5f", 'A', j, array[j]);
            if ((j + 1) % 5 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n");
    }

    public static void findGeoAvr(double[] array) {
        double mul = 1;
        for (int i = 0; i < array.length; i++) {
            mul = mul * array[i];
        }
        double geoAvr = Math.pow(mul, 1 / (double)(array.length));
        System.out.println("Среднее геометрическое значение массива B: "+geoAvr);
    }
}
