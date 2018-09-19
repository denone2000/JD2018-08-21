package by.it.nesterovich.jd01_13;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TaskC {

    private static int count = 0;
    private static String[] numbers;
    private static ArrayList<Double> strings = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String text;

        while (!(text = scanner.next()).equalsIgnoreCase("END")) {
            String[] str =text.split("\\n");
            for (String element : str) {
                readData(element);
            }

        }
    }

    static void readData(String str) throws Exception {

        try {
            Double num =Double.parseDouble(str);
            strings.add(num);

        } catch (Exception e) {
            Thread.sleep(100);
            for (int i = strings.size()-1; i >=0 ; i--) {
                System.out.print(strings.get(i) + " ");
            }
            System.out.println();
            count++;
            if (count==5) {
                throw new Exception();
            }
        }
    }
}
