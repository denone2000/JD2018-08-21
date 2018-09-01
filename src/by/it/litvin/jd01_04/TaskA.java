package by.it.litvin.jd01_04;

import by.it.litvin.jd01_03.Helper;
import by.it.litvin.jd01_03.InOut;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
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
        InOut.printArray(array, "V", 5);

        int indexFirst = 0;
        while (array[indexFirst] != first && indexFirst <= array.length) indexFirst++;

        int indexLast = 0;
        while (array[indexLast] != last && indexLast <= array.length) indexLast++;

        System.out.println("Index of first element="+ indexFirst);
        System.out.println("Index of last element=" + indexLast);
    }
}
