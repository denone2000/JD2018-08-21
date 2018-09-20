package by.it.nesterovich.jd01_13;

import java.util.Arrays;
import java.util.HashMap;

public class TaskA {

    public static void main(String[] args) {
        try {
            if (Math.random() > 0.5) {
                new HashMap<String, String>(null);
            } else {
                Integer.parseInt("привет");
            }
        } catch (Exception e) {
            StackTraceElement[] stackTrace = e.getStackTrace();
            //System.out.println(Arrays.toString(stackTrace));
            for (StackTraceElement element : stackTrace) {
                if (TaskA.class.getName().equals(element.getClassName())) {
                    System.out.println(element);
                    String name = e.getClass().getName();
                    String className = element.getClassName();
                    int numberLine = element.getLineNumber();
                    System.out.printf(
                            " name: %s\n" + "class: %s\n" + " line: %d\n",
                            name, className, numberLine
                    );
                    break;

                }
            }
        }

    }
}
