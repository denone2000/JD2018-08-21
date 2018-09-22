package by.it.galushka.jd01_13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        List<String> inputArrayList = new ArrayList();
        Scanner scanner = new Scanner(System.in);
        String inputLine;
        while (!(inputLine = scanner.next()).equalsIgnoreCase("end")) {
            inputArrayList.add(inputLine.trim());
            List<Double> doubleList = getDoubleList(inputArrayList);
            if (doubleList != null) {
                if (getSqrt(doubleList) > 0)
                    System.out.println(getSqrt(doubleList));
                else
                    break;
            } else
                break;
        }
    }

    private static double getSqrt(List<Double> list) {
        Iterator<Double> iterator = list.iterator();
        double sum = 0;
        while (iterator.hasNext()) {
            sum = sum + iterator.next();
        }
        double result = 0;
        try {
            result = Math.sqrt(sum);
            String toString = String.valueOf(result);
            if (toString.equalsIgnoreCase("nan")) {
                throw new ArithmeticException();
            }
        } catch (ArithmeticException e) {
            String myClassName = e.getClass().getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (TaskB.class.getName().equals(element.getClassName())) {
                    System.out.println(" name: " + myClassName);
                    System.out.println("class: " + element.getClassName());
                    System.out.println(" line: " + element.getLineNumber());
                    break;
                }
            }
            return -1;
        }
        return result;
    }

    private static List<Double> getDoubleList(List list) {
        List<Double> doubleList = new ArrayList<>();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()) {
            try {
                double num = Double.parseDouble((String) iterator.next());
                doubleList.add(num);
            } catch (Exception e) {
                String myClassName = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if (TaskB.class.getName().equals(element.getClassName())) {
                        System.out.println(" name: " + myClassName);
                        System.out.println("class: " + element.getClassName());
                        System.out.println(" line: " + element.getLineNumber());
                        break;
                    }
                }
                return null;
            }
        }
        return doubleList;
    }
}
