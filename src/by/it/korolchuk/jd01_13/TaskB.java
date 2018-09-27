package by.it.korolchuk.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            String string;
            Double sum = 0.0;

            while (!(string = sc.next()).equalsIgnoreCase("end")) {

                try {
                    System.out.println(Double.parseDouble(string));
                    if (Double.isNaN(Math.sqrt(Double.parseDouble(string)) + sum)) {
                        throw new ArithmeticException();
                    }
                    sum += Double.parseDouble(string);
                    System.out.println(Math.sqrt(sum));
                } catch (NumberFormatException | ArithmeticException e) {
                    for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                        if (stackTraceElement.getClassName().equals(TaskB.class.getName())) {
                            System.out.println(" name: " + e);
                            System.out.println("class: " + TaskB.class.getName());
                            System.out.println(" line: " + stackTraceElement.getLineNumber());
                        }
                    }
                }
            }
        }
    }
