package by.it.voinilo.jd01_13;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {


    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
        String s;
        Double sum = 0.0;
        while (!(s = scan.next()).equalsIgnoreCase("END")) {
            String[] numbers = s.split("\\n");
            for (String num : numbers) {
                try {
                    sum = Double.parseDouble(num) + sum;
                    if (sum < 0) {
                        throw new ArithmeticException();

                    }
                } catch (Exception ae) {
                    String myClassName = TaskB.class.getName();
                    String name = ae.getClass().getName();
                    StackTraceElement[] stackTrace = ae.getStackTrace();
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
                int ss = (int) sqrtSum;
                sqrtSum = (double) ss / 100;
                System.out.printf(Locale.ENGLISH, "%s %5.3f\n", num, sqrtSum);


            } }
    }}
