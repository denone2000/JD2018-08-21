package by.it.bindyuk.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintString {
    public static void main(String[] args) {
        Class<String> structureString = String.class;
        Method[] methodsAll = structureString.getDeclaredMethods();
        for (Method method : methodsAll) {
            if(!Modifier.isStatic(method.getModifiers())){
                System.out.printf("%s\n",method.getName());
            }
        }

    }

}
