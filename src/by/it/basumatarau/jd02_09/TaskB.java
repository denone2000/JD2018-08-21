package by.it.basumatarau.jd02_09;

import by.it.basumatarau.jd02_09.beans.Venues;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TaskB {
    private static Venues beans;

    public static void main(String[] args) {
        readXml();

        System.out.println(readJson(getJson()));

        saveXml();
    }

    private static void saveXml() {
        try(FileWriter xmlDest = new FileWriter(getFullPathTo("XML.xml"))){
            JAXBContext context = JAXBContext.newInstance(Venues.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(beans, xmlDest);
            System.out.printf("%s marshalling successful", getFullPathTo("XML.xml"));
        }catch (IOException | JAXBException e){
            e.printStackTrace();
        }
    }

    private static Venues readJson(String json) {
        return new GsonBuilder().setPrettyPrinting().serializeNulls().create().fromJson(json, Venues.class);
    }

    private static String getJson() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        String gsonVal = gson.toJson(beans);
        System.out.println("gson generated successfully:");
        System.out.println(gsonVal);
        return gsonVal;
    }

    private static void readXml() {
        try(FileReader xmlSrc = new FileReader(getFullPathTo("Venues_converted.xml"))){

            JAXBContext context = JAXBContext.newInstance(Venues.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            beans = (Venues) unmarshaller.unmarshal(xmlSrc);
            System.out.printf("successful unmarshalling %s\n", getFullPathTo("Venues_converted.xml"));

        }catch (IOException | JAXBException e){
            e.printStackTrace();
        }
    }

    private static String getFullPathTo(String xmlFileName) {
        String root = System.getProperty("user.dir");
        String srcDir = File.separator + "src" + File.separator;
        return root+
                srcDir+
                TaskA.class.getName().replaceAll(TaskA.class.getSimpleName(), "").
                        replaceAll("[.]", File.separator)+
                xmlFileName;
    }
}
