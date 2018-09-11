package by.it.basumatarau.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public static void main(String[] args) {
        Class<?> mathClass = Math.class;
        Method[] methods= mathClass.getMethods();
        for (Method method : methods) {
            if((method.getModifiers()&Modifier.STATIC)==Modifier.STATIC)
                System.out.printf("%s %s %s\n","static", method.getReturnType(),method.getName());
            if((method.getModifiers()&Modifier.PUBLIC)==Modifier.PUBLIC)
                System.out.printf("%s %s %s\n","static", method.getReturnType(),method.getName());
            if((method.getModifiers()&Modifier.PRIVATE)==Modifier.PRIVATE)
                System.out.printf("%s %s %s\n","static", method.getReturnType(),method.getName());
            //System.out.println(method);
        }
    }
}
