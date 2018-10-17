package by.it.korzik.jd02.jd02_08.TaskA;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class TaskASAX extends DefaultHandler {
    private StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        try {
            String path = System.getProperty("user.dir");
            path = path+"/src/by/it/korzik/jd02/jd02_08/";
            String xmlPath = path+"Persons.xml";
            File xmlFile = new File(xmlPath);
            TaskASAX taskASAX = new TaskASAX();
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            saxParser.parse(xmlFile,taskASAX);
        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }
    private String tab ="";
    @Override
    public void startDocument() {
        System.out.println("Start");
    }

    @Override
    public void endDocument() {
        System.out.println("END");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.println(tab+"<"+qName+ ">");
        tab=tab+"\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        String text = sb.toString().trim();
        sb.setLength(0);
        if (!text.isEmpty()){
            System.out.println(tab+text);
        }
        tab=tab.substring(1);
        System.out.println(tab+"</"+qName+ ">");

    }

    @Override
    public void characters(char[] ch, int start, int length) {
        sb.append(ch, start, length);
    }
}
