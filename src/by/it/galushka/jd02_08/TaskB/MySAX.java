package by.it.galushka.jd02_08.TaskB;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

class MySAX extends DefaultHandler {

    public static void main(String[] args) {
        try {
            String file = System.getProperty("user.dir");
            file = file.replace("\\", "/") + "/src/by/it/galushka/jd02_08/Fighters.xml";
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            MySAX mySAX = new MySAX();
            parser.parse(new File(file), mySAX);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private String tab = "";
    private StringBuilder characters = new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("startDocument");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "<" + qName);
        if (attributes.getLength() > 0) {
            for (int i = 0; i < attributes.getLength(); i++) {
                String name = attributes.getLocalName(i);
                String value = attributes.getValue(i);
                System.out.print(" " + name + " = " + value);
            }
        }
        System.out.println(">");
        tab = tab + "\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (characters.length() > 0) {
            System.out.println(tab + characters);
            characters.setLength(0);
        }
        tab = tab.substring(1);
        System.out.println(tab + "</" + qName + ">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        characters.append((new String(ch, start, length)).trim());
    }
}

