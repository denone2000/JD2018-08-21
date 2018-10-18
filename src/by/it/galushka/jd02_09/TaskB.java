package by.it.galushka.jd02_09;

import by.it.galushka.jd02_09.beans.Fighters;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private static Fighters bean;
    private static JAXBContext context;
    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public static void main(String[] args) {
        readXML();
        System.out.println("BEAN from XML:\n" +
                "==============================\n" + bean + "\n" +
                "==============================\n");
        String json = getJson();
        json = json.replace("Champion", "Champ");
        System.out.println("JSON from BEAN\n" +
                "==============================\n" + json + "\n" +
                "==============================\n");
        readJson(json);
        System.out.println("BEAN from JSON\n" +
                "==============================\n" + bean + "\n" +
                "==============================\n");
        saveXML();
    }

    static {
        try {
            context = JAXBContext.newInstance(Fighters.class);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void saveXML() {
        Marshaller marshaller = null;
        try {
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(bean, new File(Path.getXMLResult("ResultTaskB.xml")));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    private static void readJson(String json) {
        bean = gson.fromJson(json, Fighters.class);
    }

    private static String getJson() {
        return gson.toJson(bean);
    }

    private static void readXML() {
        try {
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object o = unmarshaller.unmarshal(new File(Path.getXML()));
            bean = (Fighters) o;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
