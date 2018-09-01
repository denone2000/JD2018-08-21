package by.it.yaroshchuk.jd01_03;

import java.util.Scanner;

/**
 * Created by user on 25.08.2018.
 */
public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String line = scanner.nextLine();
        String line = "44 11 55 4 5 66 77 745";
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array, "A", 4);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);


        double [][]matrix = {
                {2, 4, 0},
                {-2, 1, 3},
                {-1, 2, 1}
        };

        double [] vector = {1, 2, -1};
        double[] matrixMulVector = Helper.mul(matrix, vector);
        InOut.printArray(matrixMulVector);

        double [][]matrixLeft = {
                {1, -1},
                {2, 0},
                {3, 0}
        };
        double [][]matrixRight = {
                {1, 1},
                {2, 0}
        };
        double [][] matrixMulMatrix = Helper.mul(matrixLeft, matrixRight);
        InOut.printArray(matrixMulMatrix);
    }
}
