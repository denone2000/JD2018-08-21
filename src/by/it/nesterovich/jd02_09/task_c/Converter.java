package by.it.nesterovich.jd02_09.task_c;

import java.io.File;

abstract class Converter<T> {

    private T bean;
    private Class<T> beanClass;

    Converter(Class<T> beanClass) {
        this.beanClass = beanClass;
    }

    void save(File file) {

    }

    abstract String getText();

    abstract void load(String text);

    void load(File file) {

    }

}
