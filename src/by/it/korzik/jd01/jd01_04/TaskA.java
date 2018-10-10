package by.it.korzik.jd01.jd01_04;

import by.it.korzik.jd01.jd01_03.Helper;
import by.it.korzik.jd01.jd01_03.InOut;

import java.util.Scanner;


public class TaskA {
    static void printMulTable(){
        for (int i = 2; i <10 ; i++) {
            for (int j = 2; j <10 ; j++) {
                System.out.printf("%1d*%1d=%-3d", i,j,(i*j));
            }
            System.out.println();
        }
    }
    static void buildOneDimArray(String line){
        double[] arr = InOut.getArray(line);
        InOut.printArray(arr, "V",5);
        double first = arr[0], last=arr[arr.length-1];
        int indexFirst=0, indexLast=0;
        Helper.sort(arr);
        InOut.printArray(arr,"V",4);
        while (arr[indexFirst]!=first&&indexFirst<=arr.length) {indexFirst++;}
        while (arr[indexLast]!=last&&indexLast<=arr.length) {indexLast++;}
        System.out.println("Index of first element="+indexFirst);
        System.out.println("Index of last element="+indexLast );
    }

    public static void main(String[] args) {
        printMulTable();
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        buildOneDimArray(line);
    }
}
