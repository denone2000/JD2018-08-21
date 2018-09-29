package by.it.kuzmich.jd01.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        }
        catch (NullPointerException| NumberFormatException e){
            String myTaskName = TaskA.class.getName();
            String name = e.getClass().getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (element.getClassName().equals(myTaskName)){
                    System.out.println(" name: "+name);
                    System.out.println("class: "+element.getClassName());
                    System.out.println(" line: "+element.getLineNumber());
                }
            }
        }
    }
}
