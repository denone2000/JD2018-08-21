package by.it.yaroshchuk.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class StAX extends DefaultHandler {

    private static String tab = "";
    private static StringBuilder buffer = new StringBuilder();

    public static void main(String[] args) {
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();

        try {
            FileInputStream xml = new FileInputStream(Util.xml());
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(xml);
            while (reader.hasNext()){
                int type = reader.next();
                switch (type) {
                    case XMLStreamConstants.START_ELEMENT:
                        int length = reader.getAttributeCount();
                        System.out.println(tab + "<" + reader.getLocalName());
                        for (int i = 0; i < length; i++) {
                            String name = reader.getAttributeLocalName(i);
                            String value = reader.getAttributeValue(i);
                            System.out.print(" " + name + "=" + value);

                        }
                        System.out.println(">");
                        tab = tab + "\t";
                        buffer.setLength(0);
                        System.out.println("START ELEMENT");
                        break;
                        case XMLStreamConstants.CHARACTERS:
                            System.out.println("CARACTERS");
                            case XMLStreamConstants.END_ELEMENT:
                                System.out.println("END ELEMENT");

                }
            }

        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }

    }



    @Override
    public void startDocument() throws SAXException {
        System.out.println("startDocument()");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument()");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        int length = attributes.getLength();
        System.out.print(tab + "<" + qName );
        if(length > 0) {
            for (int i = 0; i < length; i++) {
                String name = attributes.getLocalName(i);
                String value = attributes.getValue(i);
                System.out.print(" " + name + "=" + value);
            }
        }
        System.out.println(">");
        tab = tab + "\t";
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if(buffer.length() > 0)
            System.out.println(tab + buffer.toString());
        buffer.setLength(0);
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String part = new String(ch, start, length);
        buffer.append(part.trim());
    }
}
