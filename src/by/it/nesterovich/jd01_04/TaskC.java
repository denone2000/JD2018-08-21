package by.it.nesterovich.jd01_04;

import by.it.nesterovich.jd01_03.InOut;

import java.util.Arrays;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        buildOneDimArray(string);

//        double[] testMas = {3, 4, 7, -5, 3};
//        for (int i = 0; i < testMas.length; i++) {
//            System.out.print(testMas[i] + "  ");
//        }
//        System.out.println();
//        mergeSort(testMas);
//        for (int i = 0; i < testMas.length; i++) {
//            System.out.print(testMas[i] + "  ");
//        }

    }

    static void buildOneDimArray(String line) {

        double[] array = InOut.getArray(line);

        InOut.printArray(array, "V", 5);

        double first = array[0];
        double last = array[array.length - 1];
        mergeSort(array);

        // int left = 0;
        // int right = array.length-1;
        // mergeSort(array,left,right);

        InOut.printArray(array, "V", 4);

        int indexFirst = binarySearch(array, first);
        int indexLast = binarySearch(array, last);
        System.out.println("Index of first element=" + indexFirst);
        System.out.println("Index of last element=" + indexLast);

    }

    static void mergeSort(double[] array) {
        int lengthMas = array.length;
        int n = 1;
        int shiftInMas;
        int two_size;
        double[] arr2;
        while (n < lengthMas) {
            shiftInMas = 0;
            while (shiftInMas < lengthMas) {
                if (shiftInMas + n >= lengthMas) break;
                if (shiftInMas + n * 2 > lengthMas) {
                    two_size = lengthMas - (shiftInMas + n);
                } else {
                    two_size = n;
                }
                arr2 = merge(Arrays.copyOfRange(array, shiftInMas, shiftInMas + n),
                        Arrays.copyOfRange(array, shiftInMas + n, shiftInMas + n + two_size));
                for (int i = 0; i < n + two_size; ++i)
                    array[shiftInMas + i] = arr2[i];
                shiftInMas = shiftInMas + n * 2;
            }
            n = n * 2;
        }
    }

    //доделать
    private static double[] mergeSort(double[] array, int left, int right) {


        if (array.length < 2) {
            return array;
        }
        int middle = array.length / 2;
        double[] part1 = Arrays.copyOfRange(array, left, middle);
        double[] part2 = Arrays.copyOfRange(array, middle + 1, right);


        return merge(mergeSort(part1, left, middle), mergeSort(part2, middle + 1, right));

    }

    private static double[] merge(double[] part1, double[] part2) {

        int indexPart1 = 0;
        int indexPart2 = 0;
        int lengthResultMas = part1.length + part2.length;
        double[] resultMas = new double[lengthResultMas];
        for (int i = 0; i < lengthResultMas; i++) {
            if (indexPart1 < part1.length && indexPart2 < part2.length) {
                if (part2[indexPart2] > part1[indexPart1]) {
                    resultMas[i] = part1[indexPart1];
                    indexPart1++;
                } else {
                    resultMas[i] = part2[indexPart2];
                    indexPart2++;
                }
            } else if (indexPart1 < part1.length) {
                resultMas[i] = part1[indexPart1];
                indexPart1++;
            } else {
                resultMas[i] = part2[indexPart2];
                indexPart2++;
            }
        }
        return resultMas;
    }

    static int binarySearch(double[] array, double value) {
        int indexLeft = 0;
        int indexRight = array.length - 1;
        while (indexLeft <= indexRight) {
            int middle = (indexLeft + indexRight) / 2;
            if (array[middle] == value) {
                return middle;
            } else if (array[middle] > value) {
                indexRight = middle - 1;
            } else {
                indexLeft = middle + 1;
            }
        }
        return -1;
    }
}
