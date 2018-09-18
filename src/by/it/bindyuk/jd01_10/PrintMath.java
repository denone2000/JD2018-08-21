package by.it.bindyuk.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> structureOfMath = Math.class;
        Method[] methods = structureOfMath.getMethods();
        for (Method method : methods) {
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.printf("%s %s %s %s(", "public", "static",
                        method.getReturnType(), method.getName());
                Class[] paramTypes = method.getParameterTypes();
                for (int i = 0; i < paramTypes.length; i++) {

                    paramTypes[i] = paramTypes[i];

                    System.out.printf("%s", paramTypes[i].getName());
                    if (i != paramTypes.length - 1) System.out.print(",");
                }
                System.out.print(")");
                System.out.println();
            }
        }
        Field[] methodsOfFields = structureOfMath.getFields();
        for (Field fields : methodsOfFields) {
            if (Modifier.isPublic(fields.getModifiers())) {
                System.out.printf("%s %s\n", fields.getGenericType(), fields.getName());
            }

        }
    }
}
