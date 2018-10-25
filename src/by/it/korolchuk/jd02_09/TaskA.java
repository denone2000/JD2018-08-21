package by.it.korolchuk.jd02_09;

import by.it.korolchuk.jd02_09.beans.Persons;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Persons.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object o = unmarshaller.unmarshal(new File(Path.getXML()));
            Persons persons = (Persons) o;
            System.out.println(persons);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(persons, new File(Path.getXmlResult()));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
