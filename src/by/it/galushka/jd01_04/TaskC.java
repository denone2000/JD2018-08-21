package by.it.galushka.jd01_04;

import by.it.galushka.jd01_03.Helper;
import by.it.galushka.jd01_03.InOut;

import java.sql.SQLOutput;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        buildOneDimArray(line);
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length-1];
        InOut.printArray(array,"V", 5);
        mergeSort(array);
        InOut.printArray(array, "V", 4);
        int firstIndex = binarySearch(array, first);
        int lastIndex = binarySearch(array, last);
        System.out.println("Index of first element="+firstIndex);
        System.out.println("Inswx of last element="+lastIndex);
    }

    public static void mergeSort(double[] array) {
        int startIndex = 0;
        int endIndex = array.length - 1;
        doSort(startIndex, endIndex, array);
    }

    private static void doSort(int start, int end, double[] array) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                double temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur, array);
        doSort(cur+1, end, array);
    }

    static int binarySearch(double[] array, double value) {
        int left = 0;
        int right = array.length;
        int mid;
        for (mid = (left + right)/2; array[mid] != value; mid = (left + right)/2) {
            if (right - left == 1){
                System.out.println("Данное число в массиве не найдено!");
                break;
            }
            else if (array[mid] == value) {
                break;
            }
            else if (value < array[mid]){
                right = mid-1;
            }
            else if (value > array[mid]){
                left = mid+1;
            }
        }
        return mid;
    }
}
