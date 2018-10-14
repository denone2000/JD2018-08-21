package by.it.nesterovich.jd02_09.task_c;

import by.it.nesterovich.jd02_09.beans.Films;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

abstract class Converter<Bean> {

    private Bean bean;
    private Class<Bean> beanClass;
    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    Converter(Class<Bean> beanClass) {
        this.beanClass = beanClass;
    }

    public Bean getBean() {
        return bean;
    }

    //создаёт файл с результатом конвертации
    void save(File file) {
        String string = String.valueOf(file);
        try (PrintWriter bufferedWriter = new PrintWriter(
                new FileWriter(string))
        ) {
            bufferedWriter.print(getText());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //возврат текста с результатом конвертации
    abstract String getText();

    //в полиморфный метод load конвертора может передаваться String text для обработки.
    abstract void load(String text);

    //в полиморфный метод load конвертора может передаваться File file для обработки.
    void load(File file) {
        try {
            JAXBContext context = JAXBContext.newInstance(beanClass);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object o = unmarshaller.unmarshal(file);
            bean = (Bean) o;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
