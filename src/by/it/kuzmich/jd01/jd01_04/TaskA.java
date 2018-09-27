package by.it.kuzmich.jd01.jd01_04;

import by.it.kuzmich.jd01.jd01_03.Helper;
import by.it.kuzmich.jd01.jd01_03.InOut;

import java.util.Scanner;

public class TaskA {

    private static void printMulTable(){
        for (int i = 2; i <= 9 ; i++) {
            for (int j = 2; j <= 9 ; j++) {
                System.out.printf("%1d*%1d=%-2d ",i,j,i*j);
            }
            System.out.println();
        }
    }

    private static void buildOneDimArray(String line){
        double[] array = InOut.getArray(line);
        double start  = array [0];
        double last = array [array.length-1];
        InOut.printArray(array,"V",5);
        Helper.sort(array);
        InOut.printArray(array,"V",4);
        for (int i = 0; i < array.length; i++) {
            if (array[i]==start){
                System.out.println("Index of first element=" + i);
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]==last){
                System.out.println("Index of last element=" + i);
            }
        }
    }

    public static void main(String[] args) {
        printMulTable();
        Scanner scan = new Scanner(System.in);
        String b = scan.nextLine();
        buildOneDimArray(b);
    }
}


