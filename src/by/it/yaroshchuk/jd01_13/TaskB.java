package by.it.yaroshchuk.jd01_13;

import java.util.Scanner;

import static java.lang.Double.NaN;

public class TaskB {

    public static void main(String[] args) throws ArithmeticException{
        Scanner scanner= new Scanner(System.in);
        double sum = 0;
        try {
            while (true) {
                String line = scanner.nextLine();
                if (line.equalsIgnoreCase("END"))
                    break;
                double x;
                x = Double.parseDouble(line);
                sum += x;
                double sqrt = Math.sqrt(sum);
                System.out.println("number: " + x);
                if( Double.isNaN(sqrt)) {
                    throw new ArithmeticException();
                }
                System.out.println("sqrt sum: " + sqrt);
            }
        } catch (NumberFormatException | ArithmeticException e){
            String className = TaskB.class.getName();
            String exceptionName = e.getClass().getName();
            StackTraceElement[] stackTraceElements = e.getStackTrace();
            for (StackTraceElement element : stackTraceElements) {
                if(element.getClassName().equals(className)) {
                    System.out.println(" name: " + exceptionName);
                    System.out.println("class: " + element.getClassName());
                    System.out.println(" line: " + element.getLineNumber());
                    break;
                }
            }
        }
    }
}
