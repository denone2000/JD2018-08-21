package by.it.artemliashkov.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

public class StAX {

    private static String tab = "";

    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String fileName = root + "/src/by/it/artemliashkov/jd02_07/Companies+XSD.xml";
        try (FileInputStream input = new FileInputStream(fileName)) {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(input);
            String element = "";
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        startElement(reader);
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        element = element.concat(reader.getText().trim());
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        element = endElement(reader, element);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String endElement(XMLStreamReader reader, String element) {
        if (!element.isEmpty())
            System.out.println(tab + element);
        tab = tab.substring(1);
        element = "";
        System.out.println(tab + "</" + reader.getLocalName() + ">");
        return element;
    }

    private static void startElement(XMLStreamReader reader) {
        System.out.print(tab + "<" + reader.getLocalName());
        tab = tab + "\t";
        int countAttr = reader.getAttributeCount();
        for (int i = 0; i < countAttr; i++) {
            System.out.print(" "+reader.getAttributePrefix(i)+":" + reader.getAttributeLocalName(i) + "=");
            System.out.print("\"" + reader.getAttributeValue(i) + "\"");
        }
        System.out.println(">");
    }
}
