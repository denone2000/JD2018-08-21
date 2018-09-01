package by.it.galushka.jd01_04;

import by.it.galushka.jd01_03.Helper;
import by.it.galushka.jd01_03.InOut;

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
                System.out.printf("%1d*%1d=%-3d", i, j, i * j);
            }
            System.out.println();
        }
        System.out.println();
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length-1];
        InOut.printArray(array,"V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        int firstIndex = 0;
        while (first != array[firstIndex]) firstIndex++;
        int lastIndex = 0;
        while (last != array[lastIndex]) lastIndex++;
        System.out.println("Index of first element="+firstIndex);
        System.out.println("Inswx of last element="+lastIndex);
    }
}
