package by.it.nesterovich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {

    public static void main(String[] args) {
        Class<String> stringClass = String.class;
        Method[] methodsClassString =stringClass.getDeclaredMethods();
        for (Method method : methodsClassString) {
            if ((method.getModifiers()& Modifier.STATIC)==0){
                System.out.printf("%s\n",method.getName());
            }
        }
    }
}
