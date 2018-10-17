package by.it.basumatarau.jd02_09;

import by.it.basumatarau.jd02_09.beans.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TaskA {
    public static void main(String[] args) {


        try (FileReader fr = new FileReader(getFullPathTo("Venues_XSD.xml"));
             FileWriter fw = new FileWriter(getFullPathTo("Venues_converted.xml"))
        ){
            JAXBContext context = JAXBContext.newInstance(Venues.class);

            Unmarshaller u = context.createUnmarshaller();
            Venues venues = (Venues) u.unmarshal(fr);
            System.out.printf("sucessfull unmarshalling of %s\n", getFullPathTo("Venues_XSD.xml"));


            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(venues, fw);
            System.out.printf("sucessfull marshalling of %s\n", getFullPathTo("Venues_converted.xml"));

        } catch (JAXBException | IOException e) {
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
