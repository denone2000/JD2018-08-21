package by.it.litvin.jd02_09;

import by.it.litvin.jd02_09.beans.Dota;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {

    public static void main(String[] args) {
        try {
            JAXBContext context=JAXBContext.newInstance(Dota.class);
            Unmarshaller unmarshaller=context.createUnmarshaller();
            Object o=unmarshaller.unmarshal(new File(Path.getXml("Dota+XSD.xml")));
            Dota dota=(Dota) o;
            System.out.println(dota);

            Marshaller marshaller=context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(dota,new File(Path.getXmlResult("Dota+XSD+generate.xml")));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
