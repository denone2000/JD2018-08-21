package by.it.kisielev.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;
        double sum = 0;
        while (true) {
            word = scanner.nextLine();
            if (word.equals("END"))
                break;
            try {
                String[] line = word.split("[/n]+");

                for (int i = 0; i < line.length; i++) {
                    sum += Double.parseDouble(line[i]);
                }
                double resultAll = Math.sqrt(sum);
                if (sum < 0) throw new ArithmeticException();
                System.out.println(Double.parseDouble(line[line.length - 1]) + " корень из всех чисел: " + resultAll);


            } catch (NumberFormatException | ArithmeticException e) {
                String myClassName = TaskA.class.getName();
                String name = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (element.getClassName().equals(myClassName)) {
                        System.out.println(" name: " + name);
                        System.out.println(" class: " + element.getClassName());
                        System.out.println(" line: " + element.getLineNumber());
                        break;
                    }
                }
            }
        }
    }
}