package by.it.akhmelev.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

public class SAX extends DefaultHandler{

    public static void main(String[] args) {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            SAXParser saxParser = saxParserFactory.newSAXParser();
            File xml=new File(Util.xml());
            SAX sax = new SAX();
            saxParser.parse(xml,sax);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private String tab="";
    private StringBuilder buffer=new StringBuilder();

    @Override
    public void startDocument() throws SAXException {
        System.out.println("startDocument();");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("endDocument();");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        int length = attributes.getLength();
        System.out.print(tab+"<"+qName);
        if (length>0) {
            for (int i = 0; i < length; i++) {
                String name = attributes.getQName(i);
                String value = attributes.getValue(i);
                System.out.print(" "+name+"="+value);
            }
        }
        System.out.println(">");
        tab="\t"+tab;
        buffer.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (buffer.length()>0)
            System.out.println(tab+buffer.toString());
        buffer.setLength(0);
        tab=tab.substring(1);
        System.out.println(tab+"</"+qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String part = new String(ch, start, length);
        buffer.append(part.trim());
    }
}
