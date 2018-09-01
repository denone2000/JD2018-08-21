package by.it.basumatarau.jd01_03;

import java.util.Scanner;
/** test class - invokes some of the method to theck their performance...
* */
public class Runner {
    public static void main(String[] args) {
        double [] arr = {12, 6, 8, 2, 4};

        double [][] arr2 = {{2, 2, 2, 2, 2},
                            {2, 2, 2, 2, 2},
                            {2, 2, 2, 2, 2},
                            {2, 2, 2, 2, 2},
                            {2, 2, 2, 2, 2}};

        Scanner scanner = new Scanner (System.in);
        String line = scanner.nextLine();

        InOut.printArray(arr);

        InOut.printArray(arr, "A", 4);

        InOut.printArray(Helper.mul(arr2, arr));

        Helper.sort(arr);

        InOut.printArray(arr);
    }
}
