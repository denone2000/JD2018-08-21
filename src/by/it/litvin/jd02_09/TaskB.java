package by.it.litvin.jd02_09;

import by.it.litvin.jd02_09.beans.Dota;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskB {

    private static Dota bean;

    private static JAXBContext context;
    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    public static void main(String[] args) {
        readXml();
        System.out.println("Bean from XML " + bean);
        String json= getJson();
        System.out.println("Json from BEAN "+json);
        readJson(json);
        System.out.println("Bean from JSON");
        saveXml();
    }

    static{
        try {
            context=JAXBContext.newInstance(Dota.class);

        }catch (JAXBException e){
            e.printStackTrace();
        }
    }

    private static void readXml(){
        try {
            Unmarshaller unmarshaller=context.createUnmarshaller();
            Object o=unmarshaller.unmarshal(new File(Path.getXml("Dota+XSD.xml")));
            bean=(Dota) o;
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }
    private static void saveXml(){
        Marshaller marshaller;
        try {
            marshaller=context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(bean,new File(Path.getXmlResult("Dota+XSD+generate.xml")));
        }catch (JAXBException e){
            e.printStackTrace();
        }
    }

    private static String getJson(){
        return gson.toJson(bean);
    }

    private static void readJson(String json){
        bean=gson.fromJson(json, Dota.class);
    }
}


