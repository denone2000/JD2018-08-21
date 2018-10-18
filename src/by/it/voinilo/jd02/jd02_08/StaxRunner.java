package by.it.voinilo.jd02.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class StaxRunner {
    private static String filenameXML = "src/by/it/voinilo/jd02/jd02_08/Persons.xml";

    public static void main(String[] args) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try (            FileInputStream fileInputStream = new FileInputStream(filenameXML)
        ){XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream );
        Stax instance = new Stax(reader);
        String txt= instance.parse();
            System.out.println(txt);


        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }

    }
}
