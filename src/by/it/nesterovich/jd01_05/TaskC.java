package by.it.nesterovich.jd01_05;

import java.util.ArrayList;

public class TaskC {
    public static void main(String[] args) {
        double[] array = new double[25];
        fillArray(array);
        printArray(array, "M", 5);
        System.out.println();
        double[] arrayB = selectionValues(array);
        printArray(arrayB, "M", 5);
        double geometricMean = geometricMean(arrayB);
        System.out.println("Среднее геометрическое = " + geometricMean);
    }

    private static void fillArray(double[] array) {
        double x = 5.33;
        for (int i = 0; i < array.length; i++) {
            double z = Math.cbrt(Math.pow(x, 2) + 4.5);
            x += (9 - 5.33) / array.length;
            array[i] = z;
        }
    }

    private static void printArray(double[] array, String name, int columnCount) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% 3d]=%-10.5f", name, i, array[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == array.length) {
                System.out.println();
            }
        }
    }

    private static double[] selectionValues(double[] array) {

        ArrayList<Double> selectionArray = new ArrayList<>();
        for (double element : array) {
            if (element > 3.5) {
                selectionArray.add(element);
            }
        }
        return conversionArray(selectionArray);
    }

    private static double[] conversionArray(ArrayList<Double> array) {
        double[] conversionArray = new double[array.size()];
        for (int i = 0; i < conversionArray.length; i++) {
            conversionArray[i] = array.get(i);
        }
        return conversionArray;
    }

    private static double geometricMean(double[] array) {

        double resultMultiplication = 1;
        for (double element : array) {
            resultMultiplication *= element;
        }
        double power = (double) 1 / array.length;

        return Math.pow(resultMultiplication, power);
    }
}
