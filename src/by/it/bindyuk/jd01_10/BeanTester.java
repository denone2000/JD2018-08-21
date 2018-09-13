package by.it.bindyuk.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> BeanTested = Bean.class;
        Method[] methods = BeanTested.getDeclaredMethods();
        Object o = null;

        for (Method method : methods){
            if (method.isAnnotationPresent(Param.class)) {
                Param annotation = method.getAnnotation(Param.class);
                if(Modifier.isStatic(method.getModifiers())){
                    double result = (double)(method.invoke(o,annotation.a(),annotation.b()));
                    System.out.println(method.getName() + " " + result);
                } else if(!Modifier.isStatic(method.getModifiers())) {
                    o = BeanTested.getConstructor().newInstance();

                    double result = (double) (method.invoke(o, annotation.a(), annotation.b()));
                    System.out.println(method.getName() + " " + result);
                }
            }
        }
    }
}