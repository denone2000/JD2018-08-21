package by.it.nesterovich.jd02_09;

import by.it.nesterovich.jd02_09.beans.Films;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private static Films bean;
    private static JAXBContext context;
    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public static void main(String[] args) {
        readXml();
        System.out.println(">>>>>>>> BEAN FROM XML:\n" + bean);
        String json = getJson();
        System.out.println(">>>>>>>> JSON FROM BEAN:\n" + json);
        readJson(json);
        System.out.println(">>>>>>>> BEAN FROM JSON:\n" + bean);
        saveXml();
    }

    static {
        try {
            context = JAXBContext.newInstance(Films.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }


    private static void readXml() {
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object o = unmarshaller.unmarshal(new File(Path.getXml("Films+XSD+generate.xml")));
            bean = (Films) o;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void saveXml() {
        Marshaller marshaller;
        try {
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bean, new File(Path.getXmlResult("resultB.xml")));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static String getJson() {
        return gson.toJson(bean);
    }

    private static void readJson(String json) {
        bean = gson.fromJson(json, Films.class);
    }

}
