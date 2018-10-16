package by.it.bindyuk.jd02_08;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.IOException;

class ParserStAX {
    private static String tab = "";

    public static void main(String[] args) {

        String builder = "";
        String xml = System.getProperty("user.dir").concat("/src/by/it/bindyuk/jd02_07/Transport+XSD.xml");

        try (FileInputStream fileInputStream = new FileInputStream(xml)) {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(fileInputStream);

            while (reader.hasNext()) {
                int type = reader.next();

                switch (type) {
                    case XMLStreamConstants.START_ELEMENT: {
                        System.out.print(tab + "[" + reader.getLocalName());
                        for (int i = 0; i < reader.getAttributeCount(); i++) {
                            System.out.print(" " + reader.getAttributeLocalName(i) +
                                    "=" + "\"" + reader.getAttributeValue(i) + "\"");
                        }
                        System.out.println("]");
                        tab = '\t' + tab;
                        break;
                    }
                    case XMLStreamConstants.END_ELEMENT: {
                        if (!builder.isEmpty()) {
                            System.out.println(tab + builder);
                        }
                        builder = "";
                        tab = tab.substring(1);
                        System.out.println(tab + "[/" + reader.getLocalName() + "]");
                        break;
                    }
                    case XMLStreamConstants.CHARACTERS: {
                        builder = builder.concat(reader.getText().trim());
                        break;
                    }

                }
            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
