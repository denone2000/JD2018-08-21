package by.it.voinilo.jd01.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array, "v", 3);
        System.out.println("min="+Helper.findMin(array));
        System.out.println("max="+Helper.findMax(array));
        System.out.println(Helper.sort(array));
    }

}
