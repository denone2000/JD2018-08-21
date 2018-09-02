package by.it.korolchuk.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();

        double[] array = InOut.getArray(line);

        double[][] matrix = {
                {1,2,3},
                {4,5,6}
        };
        double vector[] = {1,2,3};

        InOut.printArray(array);
        InOut.printArray(array, "A", 4);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);


        Helper.mul(matrix, vector);

        double[][] matrixLeft = matrix;

        double[][] matrixRight = {
                {1,2},
                {3,4},
                {5,6}
        };

        Helper.mul(matrixLeft, matrixRight);
    }
}
