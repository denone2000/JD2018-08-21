package by.it.bindyuk.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> BeanTested = Bean.class;
        Param param = BeanTested.getAnnotation(Param.class);
        Method[] methods = BeanTested.getDeclaredMethods();
        Object o;

        for (Method method : methods)
            if (method.isAnnotationPresent(Param.class)) {

                o = BeanTested.newInstance();

                double result = (double)(method.invoke(o,param.a(),param.b()));
                System.out.println(method.getName() + " " + result);
            }
    }
}