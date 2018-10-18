package by.it.bindyuk.jd02_09;

import by.it.bindyuk.jd02_09.beans.Transport;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private static Transport bean; // question
    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
    static private JAXBContext context;

    static {
        try {
            context = JAXBContext.newInstance(Transport.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        readXml();
        System.out.println(bean);
        String json = getJson();
        readJson(json);
        System.out.println(bean);
        saveXml();
    }

    private static void readXml() {
        try {
            Unmarshaller um = context.createUnmarshaller();
            bean = (Transport) um.unmarshal(new File(MyPath.getMyXml()));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void saveXml() {
        try {
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(bean, new File(MyPath.getXmlResult()));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static String getJson() {
        return gson.toJson(bean);
    }

    private static void readJson(String json) {
        bean = gson.fromJson(json, Transport.class);
    }
}
