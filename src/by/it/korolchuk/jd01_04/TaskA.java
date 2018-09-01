package by.it.korolchuk.jd01_04;


import by.it.korolchuk.jd01_03.Helper;
import by.it.korolchuk.jd01_03.InOut;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }
    static void printMulTable() {
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i*j);
                if (j%9==0)
                    System.out.println();
            }
        }
    }
    static void buildOneDimArray(String line) {
        double[] arr = InOut.getArray(line);
        InOut.printArray (arr, "V", 5);

        double first = arr [0];
        double last = arr[arr.length-1];

        Helper.sort(arr);
        InOut.printArray(arr, "V", 4);

        int indexFirst = 0;
        while (arr[indexFirst] != first && indexFirst <= arr.length) indexFirst++;

        int indexLast = 0;
        while (arr[indexLast] != last && indexLast <= arr.length) indexLast++;

        System.out.println("Index of first element=" + indexFirst);
        System.out.println("Index of last element=" + indexLast);
    }

}
