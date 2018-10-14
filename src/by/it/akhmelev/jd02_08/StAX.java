package by.it.akhmelev.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

public class StAX {

    public static void main(String[] args) {
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();
        try (FileInputStream xml = new FileInputStream(Util.xml())) {

            XMLStreamReader reader = inputFactory.createXMLStreamReader(xml);
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        start(reader);
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        characters(reader);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        stop(reader);
                        break;
                }
            }
        } catch (XMLStreamException | IOException e) {
            e.printStackTrace();
        }

    }

    private static void stop(XMLStreamReader reader) {
        if (buffer.length() > 0)
            System.out.println(tab + buffer.toString());
        buffer.setLength(0);
        tab = tab.substring(1);
        System.out.println(tab + "</" + reader.getLocalName() + ">");
    }

    private static void characters(XMLStreamReader reader) {
        String part = reader.getText();
        buffer.append(part.trim());
    }

    private static void start(XMLStreamReader reader) {
        int length = reader.getAttributeCount();
        System.out.print(tab + "<" + reader.getLocalName());
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                String name = reader.getAttributeLocalName(i);
                String value = reader.getAttributeValue(i);
                System.out.print(" " + name + "=" + value);
            }
        }
        System.out.println(">");
        tab = "\t" + tab;
        buffer.setLength(0);
    }

    private static String tab = "";
    private static StringBuilder buffer = new StringBuilder();

}
