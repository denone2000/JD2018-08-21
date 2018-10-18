package by.it.voinilo.jd02.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxRunner {

    private static String filenameXML = "src/by/it/voinilo/jd02/jd02_08/Persons.xml";


    public static void main(String[] args) {


        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser parser = saxParserFactory.newSAXParser();
            Sax handler = new Sax();
            parser.parse(new File(filenameXML), handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }

    }

}
