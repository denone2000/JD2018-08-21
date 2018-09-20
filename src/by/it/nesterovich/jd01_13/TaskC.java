package by.it.nesterovich.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {

    private static int count = 0;
    private static ArrayList<Double> strings = new ArrayList<>();
    private static Scanner scanner;

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        while (true) {
            readData();
        }
    }

    private static void readData() throws Exception {
        String text = scanner.nextLine();
        try {
            Double num = Double.parseDouble(text);
            strings.add(num);
        } catch (Exception e) {
            Thread.sleep(100);
            for (int i = strings.size() - 1; i >= 0; i--) {
                System.out.print(strings.get(i) + " ");
            }
            System.out.println();
            count++;
            if (count >= 5) {
                throw new Exception();
            }
        }
    }
}
