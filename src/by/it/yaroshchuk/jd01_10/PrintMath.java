package by.it.yaroshchuk.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getDeclaredMethods();
        for (Method method : methods) {
            if((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC)
                System.out.println("public " + method.getReturnType() + " " + method.getName() + " " + method.toString() +
                        " " + method.getParameterTypes());

        }
    }
}
