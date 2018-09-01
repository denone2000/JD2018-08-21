package by.it.bindyuk.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        // Scanner scanner = new Scanner(System.in);
        // String line = scanner.nextLine();
        // double[] array = InOut.getArray(line);
        // InOut.printArray(array);
        //  InOut.printArray(array, line, 4);
        double[] skd = {6, 4, 3};
        Helper.sort(skd);
        //InOut.printArray(skd);
        double[][] rrr = new double[3][2];
        for (int i = 0; i < rrr.length; i++) {
            for (int j = 0; j < rrr[0].length; j++) {
                rrr[i][j] = 2;
            }
        }
        double[][] aaa = new double[2][3];
        for (int i = 0; i < aaa.length; i++) {
            for (int j = 0; j < aaa[0].length; j++) {
                aaa[i][j] = 3;
            }
        }

                Helper.mul(rrr,aaa);

    }
}


