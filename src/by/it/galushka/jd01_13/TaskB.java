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
                System.out.println(getSqrt(doubleList));
            }
            else
                break;
        }
    }

    private static double getSqrt(List<Double> list) {
        Iterator<Double> iterator = list.iterator();
        double sum = 0;
        while (iterator.hasNext()) {
            sum = sum + iterator.next();
        }
//        try {
//            return Math.sqrt(sum);
//        }
//        catch (Exception e) {
//            String myClassName = e.getClass().getName();
//            StackTraceElement[] stackTrace = e.getStackTrace();
//            for (StackTraceElement element : stackTrace) {
//                if (TaskB.class.getName().equals(element.getClassName())) {
//                    System.out.println(" name: " + myClassName);
//                    System.out.println("class: " + element.getClassName());
//                    System.out.println(" line: " + element.getLineNumber());
//                    break;
//                }
//            }
//            return null;
//        }
        return Math.sqrt(sum);
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
