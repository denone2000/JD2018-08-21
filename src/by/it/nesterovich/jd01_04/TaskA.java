package by.it.nesterovich.jd01_04;

import by.it.nesterovich.jd01_03.Helper;
import by.it.nesterovich.jd01_03.InOut;

import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        buildOneDimArray(string);
    }

    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {

        double[] array = InOut.getArray(line);

        InOut.printArray(array, "V", 5);

        double first = array[0];
        double last = array[array.length - 1];
        Helper.sort(array);

        InOut.printArray(array, "V", 4);

        int indexFirst=0;
        int indexLast=0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == first) {
                indexFirst = i;
            }
            if (array[i] == last) {
                indexLast = i;
            }
        }
        System.out.println("Index of first element=" + indexFirst);
        System.out.println("Index of last element=" + indexLast);
    }
}
