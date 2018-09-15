package by.it.korolchuk.jd01_10;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;


public class BeanTester {
    public static void main(String[] args) throws Exception {
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method m : methods) {
            if (m.isAnnotationPresent(Param.class)) {
                Param annotation = m.getAnnotation(Param.class);

                try {

                    if ((m.getModifiers() & Modifier.STATIC) == 0) {
                        System.out.println(m.getName());
                        Bean newBean = beanClass.getDeclaredConstructor().newInstance();
                        System.out.println(m.invoke(newBean, annotation.a(), annotation.b()));

                    } else {
                        System.out.println(m.getName());
                        System.out.println(m.invoke(Bean.class, annotation.a(), annotation.b()));
                    }

                } catch (Exception e) {
                    e.printStackTrace();

                }
            }
        }
    }
}

