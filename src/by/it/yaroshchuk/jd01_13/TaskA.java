package by.it.yaroshchuk.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try{
            if(Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt(("привет"));
        } catch (NullPointerException | NumberFormatException e) {
            String className = TaskA.class.getName();
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
