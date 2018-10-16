package by.it.litvin.jd02_08;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SaxRunner {

    private static String fileName="src/by/it/litvin/jd02_08/Utill/Dota.xml";
    public static void main(String[] args) {

        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser=saxParserFactory.newSAXParser();
            Sax handler = new Sax();
            saxParser.parse(new File(fileName),handler);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}
