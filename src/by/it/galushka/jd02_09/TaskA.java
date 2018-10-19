package by.it.galushka.jd02_09;

import by.it.galushka.jd02_09.beans.Fighters;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Fighters.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object o = unmarshaller.unmarshal(new File(Path.getXML()));
            Fighters fighters = (Fighters) o;
//            System.out.println(fighters);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(fighters, new File(Path.getXMLResult("ResultTaskA.xml")));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
