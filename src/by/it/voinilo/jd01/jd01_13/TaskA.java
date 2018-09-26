package by.it.voinilo.jd01.jd01_13;

import java.util.HashMap;

public class TaskA {
    public static void main(String[] args) {

        try {
            if (Math.random() > 0.5)
                new HashMap<String, String>(null);
            else
                Integer.parseInt("привет");
        } catch (Exception E) {
            StackTraceElement[] stackTrace = E.getStackTrace();
            for (StackTraceElement elem : stackTrace) {
                if (TaskA.class.getName().equals(elem.getClassName())) {
                    System.out.println(elem);
                    String name= E.getClass().getName();
                    String classname = elem.getClassName();
                    int num = elem.getLineNumber();

                    System.out.printf("name: %s\n"+ "class: %s\n" + "line: %d",name,classname,num);



                    break;
                }
            }

        }


    }
}
