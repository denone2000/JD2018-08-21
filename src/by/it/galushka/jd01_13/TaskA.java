package by.it.galushka.jd01_13;

import java.util.HashMap;

public class TaskA {

    public static void main(String[] args) {
        try {
        if (Math.random() > 0.5)
            new HashMap<String, String>(null);
        else
            Integer.parseInt("привет");
        }
        catch (Exception e) {
            String myClassName = e.getClass().getName();
            StackTraceElement[] elements = e.getStackTrace();
            for (StackTraceElement element : elements) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    System.out.println(" name: " + myClassName);
                    System.out.println("class: " + element.getClassName());
                    System.out.println(" line: " + element.getLineNumber());
                    break;
                }
            }
        }
    }
}
