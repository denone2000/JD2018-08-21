package by.it.artemliashkov.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> classString = String.class;
        Method[] methods = classString.getDeclaredMethods();
        for (Method method : methods) {
            if((method.getModifiers()& Modifier.STATIC)==0){
                System.out.println(method.getName());
            }
        }
    }
}