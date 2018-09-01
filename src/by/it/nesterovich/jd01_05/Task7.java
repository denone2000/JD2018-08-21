package by.it.nesterovich.jd01_05;

import java.util.ArrayList;
import java.util.Arrays;

public class Task7 {

    public static void main(String[] args) {
        int[] arrayA = new int[31];
        fillArray(arrayA);
        System.out.println("\u2554");
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
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[% 3d]=%-6d", name, i, array[i]);
            if ((i + 1) % columnCount == 0 || i + 1 == array.length) {
                System.out.println();
            }
        }
    }

    private static void printArrayColumn(int[] array, String name, int rows) {
        for (int j = 0; j < rows; j++) {
            for (int i = j; i < array.length; i+=rows) {
                System.out.printf("%s[% 3d]=%-6d", name, i, array[i]);
            }
            System.out.println();
        }
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
