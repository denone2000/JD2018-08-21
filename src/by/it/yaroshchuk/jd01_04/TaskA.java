package by.it.yaroshchuk.jd01_04;

import by.it.yaroshchuk.jd01_03.Helper;
import by.it.yaroshchuk.jd01_03.InOut;

import java.util.Scanner;

/**
 * Created by user on 28.08.2018.
 */
public class TaskA {

    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        buildOneDimArray(line);
    }

    static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%1d*%1d=%-3d", i, j, i*j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line){
        double [] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];
        InOut.printArray(array, "V", 5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        int indexFirst = 0;
        while (array[indexFirst] != first && indexFirst < array.length)
            indexFirst++;

        int indexLast = 0;
        while (array[indexLast] != last && indexLast < array.length)
            indexLast++;

        System.out.println("Index of first element=" + indexFirst);
        System.out.println("Index of last element=" + indexLast);
    }
}
