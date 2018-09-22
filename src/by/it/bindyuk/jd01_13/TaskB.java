package by.it.bindyuk.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        double sum = 0;
        while (true) {
            line = scanner.nextLine();
            if (line.equals("END"))
                break;

            try {
                String[] linesInNumbers = line.split("[/n]+");

                for (int i = 0; i < linesInNumbers.length; i++) {
                    sum += Double.parseDouble(linesInNumbers[i]);
                }
                double result = Math.sqrt(sum);
                if(sum<0) throw new ArithmeticException();
                System.out.println(Double.parseDouble(linesInNumbers[linesInNumbers.length - 1]) + " " + result);


            } catch (NumberFormatException | ArithmeticException e) {

                String className = TaskB.class.getName();
                String name = e.getClass().getName();
                StackTraceElement[] arrayStack = e.getStackTrace();

                for (StackTraceElement element : arrayStack) {
                    if (element.getClassName().equals(className)) {
                        System.out.println(" name: " + name);
                        System.out.println("class: " + element.getClassName());
                        System.out.println(" line: " + element.getLineNumber());
                        break;
                    }
                }
            }
        }
    }
}



