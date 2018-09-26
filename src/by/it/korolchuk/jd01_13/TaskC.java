package by.it.korolchuk.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {

    private static int numbers = 0;
    private static ArrayList<Double> arrayList = new ArrayList<>();
    private static Scanner sc;

    public static void main(String[] args) throws Exception {
        sc = new Scanner(System.in);
        while (true) {
            readData();
        }
    }

    private static void readData() throws Exception {
        String string = sc.nextLine();
        try {
            double num = Double.parseDouble(string);
            arrayList.add(num);
        } catch (Exception e) {
            Thread.sleep(100);
            for (int i = arrayList.size() - 1; i >= 0; i--) {
                System.out.print(arrayList.get(i) + " ");

            }
            numbers++;
            if (numbers > 4) {
                throw new Exception();
            }
        }
    }
}