package by.it.korzik.jd01.jd01_13;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        String strSqrt;
        double num;
        double sqrt=0;
        double sum = 0;
        while (!(line = scan.next()).equalsIgnoreCase("end")) {
            try {
                num = Double.parseDouble(line);
                sum += num;
                sqrt = Math.sqrt(sum);
                strSqrt=Double.toString(sqrt);
                if (strSqrt.equals("NaN")){
                    throw new ArithmeticException();
                }
            } catch (ArithmeticException | NumberFormatException e) {
                String myTaskName = TaskB.class.getName();
                String name = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (element.getClassName().equals(myTaskName)) {
                        System.out.println(" name: " + name);
                        System.out.println("class: " + element.getClassName());
                        System.out.println(" line: " + element.getLineNumber());
                    }
                }
            }
            System.out.println(sqrt);
        }
    }
}
