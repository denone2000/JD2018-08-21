package by.it.litvin.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structString=String.class;
        Method[] methods = structString.getDeclaredMethods();
        for (Method method:methods) {
            if (!Modifier.isStatic(method.getModifiers())){
            System.out.printf("%s\n",method.getName());
            
        }

    }
}}
