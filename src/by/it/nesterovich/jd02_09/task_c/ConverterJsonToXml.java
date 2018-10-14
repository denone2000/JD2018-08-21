package by.it.nesterovich.jd02_09.task_c;

class ConverterJsonToXml<Bean> extends Converter<Bean> {

    ConverterJsonToXml(Class<Bean> beanClass) {
        super(beanClass);
    }

    //возврат текста с результатом конвертации
    @Override
    String getText() {
        return null;
    }

    //в полиморфный метод load конвертора может передаваться String text или File file для обработки.
    @Override
    void load(String text) {

    }
}
