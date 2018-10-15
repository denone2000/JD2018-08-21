package by.it.basumatarau.jd02_09.TaskC;

import java.io.File;

public abstract class AbstractConverter<T> {
    T bean=null;
    Class<T> beanClass;

    public enum Direction{
        XML_TO_JSON, JSON_TO_XML
    }

    public abstract void load(File src);
    public abstract void load(String src);
    public abstract void save(File dest);
    public abstract String getText();
}
