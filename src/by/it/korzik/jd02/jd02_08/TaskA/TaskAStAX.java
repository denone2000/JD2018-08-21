package by.it.korzik.jd02.jd02_08.TaskA;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class TaskAStAX extends DefaultHandler {

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        String tab = "";
        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/korzik/jd02/jd02_08/";
        String xmlPath = path + "Persons.xml";
        try (InputStream input = new FileInputStream(new File(xmlPath))) {
            XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = xmlInputFactory.createXMLStreamReader(input);
            while (reader.hasNext()) {
                int next = reader.next();
                switch (next) {
                    case XMLStreamConstants.START_ELEMENT:
                        tab = startElement(tab, reader);
                        break;
                    case XMLStreamConstants.END_ELEMENT:
                        tab = endElement(sb, tab, reader);
                        break;
                    case XMLStreamConstants.END_DOCUMENT:
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        getCharacters(sb, reader);
                        break;
                }
            }
        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private static String startElement(String tab, XMLStreamReader reader) {
        System.out.println(tab + "<" + reader.getLocalName() + ">");
        tab = tab + "\t";
        return tab;
    }

    private static void getCharacters(StringBuilder sb, XMLStreamReader reader) {
        sb.append(reader.getText());
    }

    private static String endElement(StringBuilder sb, String tab, XMLStreamReader reader) {
        String text = sb.toString().trim();
        sb.setLength(0);
        if (!text.isEmpty()) {
            System.out.println(tab + text);
        }
        tab = tab.substring(1);
        System.out.println(tab + "</" + reader.getLocalName() + ">");
        return tab;
    }
}