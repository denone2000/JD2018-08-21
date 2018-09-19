package by.it.galushka.jd01_13;

import java.util.*;

public class TaskC {

    private static List<Double> list = new ArrayList<>();
    private static int counter = 0;
    private static Scanner scanner;

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        while (true) {
            readData();
        }
    }

    static void readData() throws NumberFormatException, InterruptedException {
        try {
            Double num = Double.parseDouble(scanner.nextLine());
            list.add(num);
        } catch (Exception e) {
            if (counter >= 4) {
                throw new NumberFormatException();
            } else {
                Thread.sleep(100);
                int sizeList = list.size();
                for (int i = sizeList - 1; i >= 0; i--) {
                    double res = list.get(i);
                    System.out.print(res + " ");
                }
                System.out.println();
                counter++;
            }
        }
    }
}
