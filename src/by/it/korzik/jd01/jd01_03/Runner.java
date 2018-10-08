package by.it.korzik.jd01.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);
        InOut.printArray(array,"array",4);
        System.out.println("Max is: "+Helper.findMax(array));
        System.out.println("Min is: "+Helper.findMin(array));
        Helper.sort(array);
    }
}
