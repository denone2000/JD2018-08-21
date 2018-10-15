package by.it.akhmelev.jd02_09;

import by.it.akhmelev.jd02_09.beans.Persons;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private static Persons bean;

    private static JAXBContext context;
    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();


    public static void main(String[] args) {
        readXml();
        System.out.println("BEAN FROM XML: " + bean);
        String json = getJson();
        json=json.replace("asdasd@mail.ru","qqqqqqqqqqqqqqqqqqqqqqqqqqqqq");
        System.out.println("JSON FROM BEAN: " + json);
        readJson(json);
        System.out.println("BEAN FROM JSON" + bean);
        saveXml();
    }

    static {
        try {
            context = JAXBContext.newInstance(Persons.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    static void readXml() {
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object o = unmarshaller.unmarshal(new File(Path.getXml()));
            bean = (Persons) o;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    static void saveXml() {
        Marshaller marshaller = null;
        try {
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bean, new File(Path.getXmlResult()));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    static String getJson() {
        return gson.toJson(bean);
    }

    static void readJson(String json) {
        bean = gson.fromJson(json, Persons.class);
    }

}
