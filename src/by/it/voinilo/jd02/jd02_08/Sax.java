package by.it.voinilo.jd02.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Sax extends DefaultHandler {

    private StringBuilder text;
    private String tab;
    private StringBuilder txtBuff;

    @Override
    public void startDocument() throws SAXException {
        text = new StringBuilder();
        txtBuff = new StringBuilder();
        tab = "";
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println(text.toString());
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
        String tx = txtBuff.toString().trim();
        if (tx.length()>0)
            text.append(tab).append(tx).append("\n");
        txtBuff.setLength(0);
        tab = tab.substring(1);
        text.append(tab).append("</").append(qName).append(">\n");

    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String part = new String(ch, start, length);
        txtBuff.append(part.trim());
    }
}
