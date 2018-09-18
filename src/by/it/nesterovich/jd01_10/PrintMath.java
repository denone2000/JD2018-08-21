package by.it.nesterovich.jd01_10;

import java.lang.reflect.*;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> mathClass = Math.class;
        Method[] methodsClassMath = mathClass.getMethods();
        for (Method method : methodsClassMath) {
            if (Modifier.isPublic(method.getModifiers())) {
                System.out.printf("%s ", "public static");
                System.out.printf("%s %s%s", method.getReturnType(), method.getName(), "(");
                String delimiter = "";
                for (Class<?> passedType : method.getParameterTypes()) {
                    System.out.printf("%s%s", delimiter, passedType.getSimpleName());
                    delimiter = ",";
                }
                System.out.printf("%s \n", ")");
            }
        }

        Field[] fieldsClassMath = mathClass.getFields();
        for (Field field : fieldsClassMath) {
            if (Modifier.isPublic(field.getModifiers())) {
                System.out.printf("%s ", "public");
                System.out.printf("%s %s\n", field.getType(), field.getName());
            }
        }
    }
}
