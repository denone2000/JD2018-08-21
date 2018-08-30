package basumatarau.jd01_04;
import by.it.basumatarau.jd01_03.Helper;
import by.it.basumatarau.jd01_03.InOut;

import java.util.*;

public class TaskA {

    public static void main(String[] args) {

        printMulTable();
        Scanner scanner = new Scanner(System.in);
        buildOneDimArray(scanner.nextLine());

    }

    public static void printMulTable(){
        for (int i = 2; i < 10; i++) {
            for (int j = 2; j < 10; j++) {
                System.out.printf("%d*%d=%-2d ", i, j, i*j);
            }
            System.out.print('\n');
        }
    }

    public static void buildOneDimArray(String line){
        double[] doubleArr = InOut.getArray(line);
        int firstInd = 0;
        int lastInd = doubleArr.length -1;
        double firstDoubleItem = doubleArr[firstInd];
        double lastDoubleItem = doubleArr[lastInd];

        InOut.printArray(doubleArr, "V", 5);
        Helper.sort(doubleArr);
        InOut.printArray(doubleArr, "V", 4);

        while (firstDoubleItem != doubleArr[firstInd]) firstInd++;
        while (lastDoubleItem != doubleArr[lastInd]) lastInd--;

        System.out.println("first element=" + firstInd);
        System.out.println("last element=" + lastInd);
    }
}
