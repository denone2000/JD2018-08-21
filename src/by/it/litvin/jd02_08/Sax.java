package by.it.litvin.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Sax extends DefaultHandler {

    private StringBuilder text;
    private StringBuilder buff;
    private String tab = "";


    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start");
        text = new StringBuilder();
        buff = new StringBuilder();

    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(text.toString());
        System.out.println("Finish");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        text.append(tab).append("<").append(qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            text.append(" ").append(name).append("=\"").append(value).append("\"");

        }
        text.append(">\n");
        tab = tab + "\t";
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String tx = buff.toString().trim();
        if (tx.length() > 0)
            text.append(tab).append(tx).append("\n");
        buff.setLength(0);
        tab = tab.substring(1);
        text.append(tab).append("</").append(qName).append(">\n");

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String part = new String(ch, start, length);
        buff.append(part);
    }
}
