package by.it.basumatarau.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;

public class SAX_StAX extends DefaultHandler {
    private static String offsetTab="";
    private static StringBuilder value = new StringBuilder();
    public static void main(String[] args) {
        System.out.println("-----------------SAX_parser--------------------");
        SAX_StAX SAXInstance = new SAX_StAX();
        SAXParserFactory factory = SAXParserFactory.newInstance();

        try (InputStream inputStream = new FileInputStream(SAXInstance.getXmlFileName("Venues.xml"))){
            SAXParser parser = factory.newSAXParser();
            parser.parse(inputStream, SAXInstance);

        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }

        System.out.println("--------------StAX_parser----------------------");
        XMLInputFactory inputFactory = XMLInputFactory.newInstance();

        try(InputStream inputStream = new FileInputStream(SAXInstance.getXmlFileName("Venues.xml")))
        {
            XMLStreamReader xmlStreamReader= inputFactory.createXMLStreamReader(inputStream);
            while(xmlStreamReader.hasNext()){
                int type = xmlStreamReader.next();
                switch (type){
                    case XMLStreamReader.START_ELEMENT:
                        System.out.print(offsetTab+"<"+xmlStreamReader.getLocalName());
                        for (int i = 0; i < xmlStreamReader.getAttributeCount(); i++) {
                            System.out.print(" "+xmlStreamReader.getAttributeLocalName(i)+"=\""+xmlStreamReader.getAttributeValue(i)+"\"");
                        }
                        System.out.println(">");
                        //noinspection StringConcatenationInLoop
                        offsetTab+='\t';
                        value.setLength(0);
                        break;
                    case XMLStreamReader.END_ELEMENT:
                        if(value.length()>0) {
                            System.out.println(offsetTab + value.toString());
                            value.setLength(0);
                        }
                        offsetTab=offsetTab.substring(1);
                        System.out.println(offsetTab+"</"+xmlStreamReader.getLocalName()+">");
                        break;
                        case XMLStreamConstants.CHARACTERS:
                            value.append(xmlStreamReader.getText().trim());
                            break;
                }
            }
        }catch (IOException | XMLStreamException e){
            e.printStackTrace();
        }
    }

    private String getXmlFileName(String xmlFileName) {
        String root = System.getProperty("user.dir");
        String srcDir = File.separator + "src" + File.separator;
        return root+
                srcDir+
                this.getClass().getName().replaceAll(this.getClass().getSimpleName(), "").
                        replaceAll("[.]", File.separator)+
                xmlFileName;
    }

    @Override
    public void startDocument() {
        //System.out.println("startDocument();");
    }

    @Override
    public void endDocument() {
        //System.out.println("endDocument();");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        System.out.print(offsetTab+"<"+qName);
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.print(" "+attributes.getLocalName(i)+"=\""+attributes.getValue(i)+"\"");
        }
        System.out.println(">");
        offsetTab+='\t';
        value.setLength(0);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {
        if(value.length()>0) {
            System.out.println(offsetTab + value.toString());
            value.setLength(0);
        }
        offsetTab=offsetTab.substring(1);
        System.out.println(offsetTab+"</"+qName+">");
    }

    @Override
    public void characters(char[] ch, int start, int length) {
        value.append(new String(ch, start, length).trim());
    }
}
