package by.it.nesterovich.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class BeanTester {

    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] methodsBeanClass = beanClass.getDeclaredMethods();
        for (Method method : methodsBeanClass) {
            if (method.isAnnotationPresent(Param.class)) {
                Param ann = method.getAnnotation(Param.class);
                if (!Modifier.isStatic(method.getModifiers())) {
                    System.out.println(method.getName());
                    System.out.println(method.invoke(beanClass.newInstance(), ann.a(), ann.b()));
                } else {
                    System.out.println(method.getName());
                    System.out.println(method.invoke(beanClass, ann.a(), ann.b()));
                }
            }
        }
    }
}

