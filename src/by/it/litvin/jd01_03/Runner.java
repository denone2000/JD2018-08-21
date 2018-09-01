package by.it.litvin.jd01_03;

import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        /**
         * @param skd вектор
         * @param arrr матрица
         */
        //Scanner sc = new Scanner(System.in);
        //String line = sc.nextLine();
        //String line = sc.nextLine();
        //double[] array = InOut.getArray(line);
        //InOut.printArray(array);
        //InOut.printArray(array,"A",4);
        double[] skd = {6, 4, 3};
        double a = Helper.findMax(skd);
        System.out.println(a);
        double b = Helper.findMin(skd);
        System.out.println(b);
        Helper.sort(skd);
        InOut.printArray(skd);
        double [][] arrr = new double[4][3];
        for (int i = 0; i <arrr.length ; i++) {
            for (int j = 0; j <arrr[0].length ; j++) {
                arrr[i][j]=2;
                Helper.mul(arrr,skd);




            }

        }
    }}






