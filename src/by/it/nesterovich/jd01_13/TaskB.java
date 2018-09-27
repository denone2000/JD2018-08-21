package by.it.nesterovich.jd01_13;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;
        int sum = 0;
        while (!(text = scanner.next()).equalsIgnoreCase("END")) {
            String[] numbers = text.split("\\n");
            for (String number : numbers) {
                try {
                    sum += Double.parseDouble(number);
                    if (sum < 0) {
                        throw new ArithmeticException();
                    }
                } catch (Exception e) {
                    String myClassName = TaskB.class.getName();
                    String name = e.getClass().getName();
                    StackTraceElement[] stackTrace = e.getStackTrace();
                    for (StackTraceElement element : stackTrace) {
                        if (element.getClassName().equals(myClassName)) {
                            System.out.println(" name: " + name);
                            System.out.println("class: " + element.getClassName());
                            System.out.println(" line: " + element.getLineNumber());
                            break;
                        }
                    }
                }
                double sqrtSum = Math.sqrt(sum);
                sqrtSum = sqrtSum * 100;
                int s = (int) sqrtSum;
                sqrtSum = (double) s / 100;
                System.out.printf(Locale.ENGLISH, "%s %5.3f\n", number, sqrtSum);
            }
        }
    }
}
