package by.it.basumatarau.jd01_10;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {

    public static void main(String[] args) {
        Class<Bean> classBean = Bean.class;
        Method[] methods = classBean.getMethods();
        for (Method method : methods) {
            if(method.isAnnotationPresent(Param.class)) {
                Param ann = method.getAnnotation(Param.class);
                try {
                    if ((method.getModifiers() & Modifier.STATIC) == 0) {
                        System.out.println(method.getName());
                        Bean someObj = classBean.newInstance();
                        System.out.println(method.invoke(someObj, ann.a(), ann.b()));
                    } else {
                        System.out.println(method.getName());
                        System.out.println(method.invoke(Bean.class, ann.a(), ann.b()));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
