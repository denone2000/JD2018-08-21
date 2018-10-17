package by.it.nesterovich.jd02_09;

import by.it.nesterovich.jd02_09.beans.Films;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Films.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object o = unmarshaller.unmarshal(new File(Path.getXml("Films+XSD.xml")));
            Films films = (Films) o;
            System.out.println(films);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(films, new File(Path.getXmlResult("Films+XSD+generate.xml")));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
