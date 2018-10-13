package by.it.litvin.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class StAXRunner {

    private static String fileName = "src/by/it/litvin/jd02_08/Utill/Dota.xml";

    public static void main(String[] args) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try (FileInputStream fileInputStream = new FileInputStream(fileName)) {
            XMLStreamReader reader = inputFactory.createXMLStreamReader(fileInputStream);

            StAX instance = new StAX(reader);
            String txt = instance.parse();
            System.out.println(txt);


        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
