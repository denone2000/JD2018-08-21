package by.it.bindyuk.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (NullPointerException | NumberFormatException e) {
            String className = TaskA.class.getName();
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

