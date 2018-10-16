package by.it.artemliashkov.jd02_09;

import by.it.artemliashkov.jd02_09.beans.Companies;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {

    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Companies.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            Object o = unmarshaller.unmarshal(new File(Path.getXml("Companies+XSD.xml")));
            Companies companies = (Companies) o;
            System.out.println(companies);

            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(companies, new File(Path.getXmlResult("Companies+XSD+generate.xml")));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
