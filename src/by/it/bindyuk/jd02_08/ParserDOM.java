package by.it.bindyuk.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

class ParserDOM {

    public static void main(String[] args) {
        String xml = System.getProperty("user.dir").concat("/src/by/it/bindyuk/jd02_07/Transport+XSD.xml");
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xml);
            Element el = doc.getDocumentElement();
            printDom("", el);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

    private static void printDom(String prefix, Node node) {
        String text = node.getNodeValue();
        if (text != null) {
            System.out.println(prefix + "\n" + text.trim());
        }


        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            printDom(prefix + node.getNodeName(), childNodes.item(i));
        }
    }
}
