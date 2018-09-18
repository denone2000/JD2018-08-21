package by.it.kisielev.jd01_04;



import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String Line = scanner.nextLine();
        buildOneDimArray(Line);
    }


    static void printMulTable() {
        for (int i = 2; i <= 9; i++) {
            for (int j = 2; j <= 9; j++) {
                System.out.printf("%1d*%1d=%-2d ", i, j, i * j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        double first = array[0];
        InOut.printArray(array, "V", 5);
        double last = array[array.length - 1];
        Helper.sort(array);
        InOut.printArray(array,"V",4);
        int indexFirst=0;
        while(array[indexFirst]!=first && indexFirst<=array.length) {
            indexFirst++;
        }
        int indexLast=0;
        while(array[indexLast]!=first && indexLast>=array.length) {
            indexLast++;
        }
        System.out.println("Index of first element="+indexFirst);
        System.out.println("Index of last element="+indexLast);
    }

}

