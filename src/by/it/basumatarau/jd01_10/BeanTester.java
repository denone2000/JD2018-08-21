package by.it.basumatarau.jd01_10;

import java.lang.reflect.Method;

public class BeanTester {
    public static void main(String[] args) {
        Class<Bean> classBean = Bean.class;
        Method[] methosds = classBean.getMethods();
        for (Method method : methosds) {
            System.out.println("");
        }
    }
}
