package by.it.basumatarau.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> mathClass = Math.class;
        Method[] methods= mathClass.getMethods();
        for (Method method : methods) {
            if ((method.getModifiers()&Modifier.PUBLIC)!=0) {
                System.out.printf("%s ", "public");
                if ((method.getModifiers() & Modifier.STATIC) != 0) System.out.printf("%s ", "static");
                System.out.printf("%s %s", method.getReturnType().getSimpleName(), method.getName());
                String delimiter ="(";
                for (Class<?> passedType : method.getParameterTypes()) {
                    System.out.printf("%s%s", delimiter, passedType.getSimpleName());
                    delimiter = ",";
                }
                if (delimiter.equals("(")) System.out.printf("%s", delimiter);
                System.out.println(")");
            }
        }
        Field[] fieldsMath = mathClass.getFields();
        for (Field field : fieldsMath) {
            if ((field.getModifiers()&Modifier.PUBLIC)!=0){
                System.out.printf("%s ", "public");
                if ((field.getModifiers()&Modifier.STATIC)!=0) System.out.printf("%s ", "static");
                System.out.printf("%s %s\n", field.getType(), field.getName());
            }
        }
    }
}
