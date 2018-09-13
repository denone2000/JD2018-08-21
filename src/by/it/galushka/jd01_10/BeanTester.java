package by.it.galushka.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {

    public static void main(String[] args) {
        Class<Bean> beanClass = Bean.class;
        Method[] methods = beanClass.getDeclaredMethods();
        for (Method method : methods) {
            Param ann = beanClass.getAnnotation(Param.class);
            try {
                Bean obj = beanClass.newInstance();
                System.out.println(method.invoke(obj, ann.a(), ann.b()));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
