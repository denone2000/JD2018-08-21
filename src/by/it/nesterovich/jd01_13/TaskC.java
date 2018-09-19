package by.it.nesterovich.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {

    private static int count = 0;
    private static ArrayList<Double> strings = new ArrayList<>();
    private static Scanner scanner;

    public static void main(String[] args) throws Exception {
        scanner = new Scanner(System.in);
        while (count <= 5) {
            readData();
        }
    }

    private static void readData() throws Exception {
        String text = scanner.next();
        String[] numbers = text.split("\\n");
        try {
            for (String number : numbers) {
                Double num = Double.parseDouble(number);
                if (count < 5) {
                    strings.add(num);
                } else {
                    count++;
                    throw new Exception();
                }
            }
        } catch (Exception e) {
            Thread.sleep(100);
            for (int i = strings.size() - 1; i >= 0; i--) {
                System.out.print(strings.get(i) + " ");
            }
            System.out.println();
            count++;
        }
    }
}
