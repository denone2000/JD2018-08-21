package by.it.bindyuk.jd01_13;

import java.util.*;

public class TaskC {
    private static Scanner scanner;
    private static List<Double> list = new ArrayList<>();
    private static int buff = 0;

    private static void readData() throws InterruptedException, StackOverflowError {

        try {
            list.add(Double.parseDouble(scanner.nextLine()));

        } catch (NumberFormatException e) {
            buff++;
            if (buff > 5) {
                throw new StackOverflowError();
            }
            Thread.sleep(100);
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }


    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        while (true) {
            try {
                readData();
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
        }
    }
}

