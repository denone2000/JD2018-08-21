package by.it.bindyuk.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

class ParserSAX extends DefaultHandler {

    private String tab = "";
    private String builder = "";

    public static void main(String[] args) {
        try {
            String xml = System.getProperty("user.dir").concat("/src/by/it/bindyuk/jd02_07/Transport+XSD.xml");
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            ParserSAX myParser = new ParserSAX();
            parser.parse(new File(xml), myParser);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void startDocument() {
        System.out.println("START Document");
    }

    @Override
    public void endDocument() {
        System.out.println("END Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.print(tab + "[" + qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(" " + attributes.getLocalName(i) + "=" + attributes.getValue(i));
        }
        System.out.println("]");
        tab = '\t' + tab;
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if (!builder.isEmpty()) {
            System.out.println(tab + builder);
        }
        builder = "";
        tab = tab.substring(1);
        System.out.println(tab + "[/" + qName + "]");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        builder = builder.concat(new String(ch, start, length)).trim();
    }

}
