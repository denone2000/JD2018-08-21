package by.it.nesterovich.jd02_09.task_c;

public class ConverterXmlToJson<T> extends Converter<T> {

    public ConverterXmlToJson(Class<T> beanClass) {
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
