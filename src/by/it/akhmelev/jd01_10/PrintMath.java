package by.it.akhmelev.jd01_10;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structMath = Math.class;
        Method[] methods = structMath.getMethods();
        for (Method method : methods) {
            if (Modifier.isStatic(method.getModifiers()))
                System.out.printf(
                        "%s %s %s()\n",
                        "static", method.getReturnType(), method.getName()
                );
        }

    }
}
