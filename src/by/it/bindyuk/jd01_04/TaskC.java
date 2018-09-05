package by.it.bindyuk.jd01_04;

import by.it.bindyuk.jd01_03.Helper;
import by.it.bindyuk.jd01_03.InOut;

import java.util.Arrays;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        double[] a = {5.0, 3.0, 2.0, 6.0};
        mergeSort(a);
        InOut.printArray(a);
    }


    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array, "V", 5);
        int indexFirst = 0;
        while (array[indexFirst] != first && indexFirst <= array.length) indexFirst++;
        int indexLast = 0;
        while (array[indexLast] != last && indexLast <= array.length) indexLast++;
        System.out.println("Index of first element=" + indexFirst);
        System.out.println("Index if last element=" + indexLast);
    }


    static void mergeSort(double[] array) {

        double[] tmp = mergeSort(array, 0, array.length-1);
        for (int i = 0; i < array.length; i++) {
            array[i] = tmp[i];
        }
    }

    private static double[] mergeSort(double[] array, int left, int right) {
        if (array.length <= 1)
            return array;
        int m = (left + right) / 2;
        double[] array1 = Arrays.copyOfRange(array, 0, m+1);
        double[] array2 = Arrays.copyOfRange(array, m + 1, array.length);
        return merge(mergeSort(array1, 0, m), mergeSort(array2, 0, array2.length-1));
    }

    private static double[] merge(double[] part1, double[] part2) {
        double[] resMas = new double[part1.length + part2.length];
        int i1 = 0;
        int i2 = 0;
        for (int i = 0; i < resMas.length; i++) {
            if (part1.length == i1) {
                resMas[i] = part2[i2++];
            } else if (part2.length == i2) {
                resMas[i] = part1[i1++];
            } else {
                if (part1[i1] < part2[i2]) {
                    resMas[i] = part1[i1++];
                } else {
                    resMas[i] = part2[i2++];
                }
            }
        }
        return resMas;
    }
}
