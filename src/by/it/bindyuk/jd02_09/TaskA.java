package by.it.bindyuk.jd02_09;

import by.it.bindyuk.jd02_09.beans.Transport;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(Transport.class);
            Unmarshaller um = context.createUnmarshaller();
            Object unmarshal = um.unmarshal(new File(MyPath.getMyXml()));
            Transport transport = (Transport) unmarshal;
            System.out.println(transport);

            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            m.marshal(transport, new File(MyPath.getXmlResult()));

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
