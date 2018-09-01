package by.it.galushka.jd01_03;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr);
        InOut.printArray(arr, "A", 4);
        double x = Helper.findMin(arr);
        double y = Helper.findMax(arr);
        System.out.println(x);
        System.out.println(y);
        Helper.sort(arr);
        double[][] matrixLeft = {{1,2,4},{2,0,3}};
        double[][] matrixRight = {{2,5},{1,3},{1,1}};
        double[][] res = Helper.mul(matrixLeft, matrixRight);
        Print.printRes(res);
    }
}
