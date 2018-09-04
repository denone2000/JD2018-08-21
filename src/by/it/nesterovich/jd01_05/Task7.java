package by.it.nesterovich.jd01_05;

import java.util.ArrayList;
import java.util.Arrays;

public class Task7 {

    public static void main(String[] args) {
        int[] arrayA = new int[31];
        fillArray(arrayA);

        printArray(arrayA, "M", 5);
        System.out.println();

        int[] arrayB = selectionValues(arrayA);
        Arrays.sort(arrayB);
        printArrayColumn(arrayB, "B", 7);
    }

    private static void fillArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 347 + 103);
        }
    }

    private static void printArray(int[] array, String name, int columnCount) {
        System.out.println("Massiv A (index to rows)");
        System.out.print("\u250c");
        for (int i = 0; i < columnCount; i++) {
            System.out.print("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
        }
        System.out.println("\u2510");
        System.out.print("\u2502");
        for (int i = 0; i < columnCount; i++) {
            System.out.print("\u250c\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510");
        }
        System.out.println("\u2502");
        System.out.print("\u2502");

        for (int i = 0; i < array.length; i++) {
            System.out.print("");
            System.out.printf("\u2502%s[% 3d]=%-4d\u2502", name, i, array[i]);
            if ((i + 1) % columnCount == 0) {
                System.out.println("\u2502");
                System.out.print("\u2502");
                for (int k = 0; k < columnCount; k++) {
                    System.out.print("\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518");
                }
                System.out.println("\u2502");
                System.out.print("\u2502");
                for (int k = 0; k < columnCount; k++) {
                    System.out.print("\u250c\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510");
                }
                System.out.println("\u2502");
                System.out.print("\u2502");
            }
        }

        System.out.println("\u2502");
        System.out.print("\u2502");
        for (int k = 0; k < columnCount; k++) {
            System.out.print("\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518");
        }
        System.out.println("\u2502");
        System.out.print("\u2514");
        for (int i = 0; i < columnCount; i++) {
            System.out.print("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
        }
        System.out.println("\u2518");
    }

    private static void printArrayColumn(int[] array, String name, int rows) {
        System.out.println("Massiv B (index to cols)");
        int lengthRows;
        if (array.length % rows == 0) {
            lengthRows = array.length / rows;
        } else {
            lengthRows = array.length / rows + 1;
        }
        System.out.print("\u250c");
        for (int i = 0; i < lengthRows; i++) {
            System.out.print("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
        }
        System.out.println("\u2510");
        for (int j = 0; j < rows; j++) {
            System.out.print("\u2502");
            for (int i = 0; i < lengthRows; i++) {
                System.out.print("\u250c\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510");
            }
            System.out.println("\u2502");
            System.out.print("\u2502");

            for (int i = j; i < array.length; i += rows) {
                System.out.printf("\u2502%s[% 3d]=%-4d\u2502", name, i, array[i]);
//                if (array.length<lengthRows*rows){  //определить условие или что-то другое
//                    System.out.print("\u2502"+"           "+"\u2502");
//                }
            }

            System.out.println("\u2502");
            System.out.print("\u2502");
            for (int i = 0; i < lengthRows; i++) {
                System.out.print("\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518");
            }
            System.out.println("\u2502");
        }
        System.out.print("\u2514");
        for (int i = 0; i < lengthRows; i++) {
            System.out.print("\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500");
        }
        System.out.println("\u2518");
    }

    private static int[] selectionValues(int[] array) {

        ArrayList<Integer> selectionArray = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] * 0.1 > i) {
                selectionArray.add(array[i]);
            }
        }
        return conversionArray(selectionArray);
    }

    private static int[] conversionArray(ArrayList<Integer> array) {
        int[] conversionArray = new int[array.size()];
        for (int i = 0; i < conversionArray.length; i++) {
            conversionArray[i] = array.get(i);
        }
        return conversionArray;
    }


}
