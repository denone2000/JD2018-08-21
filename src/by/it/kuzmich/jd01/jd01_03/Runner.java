package by.it.kuzmich.jd01.jd01_03;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();

        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array,"V",3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
    }
}
