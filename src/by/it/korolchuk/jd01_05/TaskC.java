package by.it.korolchuk.jd01_05;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        double z;
        double[] arr = new double[40];

        for (int i = 0; i < arr.length; i++) {
            for (double x = 5.33; x <= 9; x += 0.2) {
                z = cbrt((x * x) + 4.5);
                arr[i] = z;
                i++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i % 5 == 0) System.out.println();
            System.out.printf("%3s [%3d] =%12.10f", "A", i, arr[i]);
        }
        System.out.println();
        System.out.println();


        double min = 3.5;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > min) {
                if (i % 5 == 0) System.out.println();
                System.out.printf("%3s [%3d] =%12.10f", "B", i, arr[i]);
            }
        }
        System.out.println();
        System.out.println();

        sum(arr);
        double average = sum(arr) / arr.length;
        System.out.println(average);

    }

    static double sum(double[] arr) {
        double sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}

