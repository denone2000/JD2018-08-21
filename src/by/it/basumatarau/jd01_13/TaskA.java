package by.it.basumatarau.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {

        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (Exception e) {
            String className = TaskA.class.getName();
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                if(stackTraceElement.getClassName().equals(className)){
                    System.out.println(" name: "+e);
                    System.out.println("class: "+className);
                    System.out.println(" line: "+ e.getStackTrace()[0].getLineNumber());

                    break;
                }
            }
        }
    }
}
