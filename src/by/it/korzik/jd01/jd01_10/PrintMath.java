package by.it.korzik.jd01.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class PrintMath {
    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methods = mathClass.getMethods();
        Field[] fields = mathClass.getFields();
        for (Method method : methods) {
            if (((method.getModifiers()) & Modifier.PUBLIC) == Modifier.PUBLIC) {
                String varTypes = Arrays.toString(method.getParameterTypes());
                varTypes = varTypes.replace('[', ' ').replace(']', ' ').trim();
                varTypes = varTypes.replaceAll("\\s+", "");
                System.out.printf("%s %s %s %s(%s)\n", "public", "static", method.getReturnType(), method.getName(), varTypes);
            }
        }
        for (Field field : fields) {
            System.out.println(field.getGenericType() + " " + field.getName());
        }
    }
}
