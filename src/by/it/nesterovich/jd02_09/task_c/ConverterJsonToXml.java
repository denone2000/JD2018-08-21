package by.it.nesterovich.jd02_09.task_c;

public class ConverterJsonToXml<T> extends Converter<T> {

    public ConverterJsonToXml(Class<T> beanClass) {
        super(beanClass);
    }

    @Override
    String getText() {
        return null;
    }

    @Override
    void load(String text) {

    }
}
