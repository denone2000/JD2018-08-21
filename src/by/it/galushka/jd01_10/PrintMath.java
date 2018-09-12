package by.it.galushka.jd01_10;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrintMath {

    public static void main(String[] args) {
        Class<Math> clsMath = Math.class;
        Method[] methods = clsMath.getDeclaredMethods();
        for (Method method : methods) {
            if (((method.getModifiers() & Modifier.PUBLIC) == Modifier.PUBLIC) && ((method.getModifiers() & Modifier.STATIC) == Modifier.STATIC)) {
                Parameter[] parameters = method.getParameters();
                StringBuilder parameter = new StringBuilder();
                for (int i = 0; i < parameters.length; i++) {
                    String strParameter = parameters[i].getType().toString();
                    Pattern compile = Pattern.compile("([A-z]+)");
                    Matcher matcher = compile.matcher(strParameter);
                    while (matcher.find()) {
                        if (parameters[i] == parameters[parameters.length-1])
                            parameter.append(matcher.group().trim());
                        else
                            parameter.append(matcher.group().trim()).append(",");
                    }
                }
                System.out.printf("%s %s %s %s(%s)\n", "public", "static", method.getReturnType(), method.getName(), parameter);
            }
        }
        Field[] fields = clsMath.getFields();
        for (Field field : fields) {
            String type = field.getType().toString();
            String name = field.getName().toString();
            System.out.printf("%s %s\n", type, name);
        }
    }
}
