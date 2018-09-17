package by.it.kisielev.jd01_10;


import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class PrintMath {
    public  static void main(String[] args){
       Class<Math> structMath = Math.class;
       Method[] metods=structMath.getMethods();
        for (Method method: metods) {
           if ((method.getModifiers()& Modifier.STATIC)==Modifier.STATIC)
            System.out.printf(
                    "%s %s %s()\n",
                    "public static", method.getReturnType(), method.getName());
        }


    }
}
