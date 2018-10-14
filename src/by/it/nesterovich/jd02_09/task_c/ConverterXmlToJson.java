package by.it.nesterovich.jd02_09.task_c;

import com.google.gson.GsonBuilder;

class ConverterXmlToJson<Bean> extends Converter<Bean> {

    ConverterXmlToJson(Class<Bean> beanClass) {
        super(beanClass);
    }

    //возврат текста с результатом конвертации
    @Override
    String getText() {
        return new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(getBean());
    }

    //в полиморфный метод load конвертора может передаваться String text или File file для обработки.
    @Override
    void load(String text) {

    }
}
