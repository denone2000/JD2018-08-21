package by.it.nesterovich.jd02_09.task_c;

import com.google.gson.GsonBuilder;

class ConverterXmlToJson<Bean> extends Converter<Bean> {

    ConverterXmlToJson(Class<Bean> beanClass) {
        super(beanClass);
    }

    @Override
    String getText() {
        return new GsonBuilder().serializeNulls().setPrettyPrinting().create().toJson(getBean());
    }

    @Override
    void load(String text) {
    }
}
