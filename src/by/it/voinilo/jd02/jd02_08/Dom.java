package by.it.voinilo.jd02.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.print.Doc;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Locale;

public class Dom {
    private static String filenameXML = "src/by/it/voinilo/jd02/jd02_08/Persons.xml";

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        DocumentBuilder builder = null;
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse(filenameXML);
            Element el = doc.getDocumentElement();
            printDom("", el);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }


    }
    private static void printDom(String s, Node node) {
    String text = node.getNodeValue();
    if (text!=null){
        System.out.println(s + text.trim());
    }

        NodeList child = node.getChildNodes();
        for (int i = 0; i < child.getLength(); i++) {
            printDom(s+node.getNodeName()+">", child.item(i));
        }
    }

}
