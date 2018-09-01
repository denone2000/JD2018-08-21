package by.it.korolchuk.jd01_04;

import by.it.korolchuk.jd01_03.InOut;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);

        double first = array[0];
        double last = array[array.length - 1];

        mergeSort(array);
        InOut.printArray(array, "V", 4);

        int indexFirst = 0;
        while (array[indexFirst] != first && indexFirst <= array.length) indexFirst++;

        int indexLast = 0;
        while (array[indexLast] != last && indexLast <= array.length) indexLast++;

        System.out.println("Index of first element=" + indexFirst);
        System.out.println("Index of last element=" + indexLast);
    }

    static void mergeSort(double[] array) {

        double[] subArr1 = new double[array.length / 2 + 1];
        double[] subArr2 = new double[array.length / 2];
        System.arraycopy(array, 0, subArr1, 0, subArr1.length);
        System.arraycopy(array, subArr1.length, subArr2, 0, subArr2.length);

        int i = 0;
        int j = 0;


    }
}
