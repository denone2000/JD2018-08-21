package by.it.bindyuk.jd02_08;

import org.w3c.dom.*;
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
        if (node.hasChildNodes()) {
            System.out.print(prefix + "[" + node.getNodeName());
            if (node.hasAttributes()) {
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.print(" " + attributes.item(i).getNodeName()
                            + "=" + attributes.item(i).getNodeValue());
                }
            }
            System.out.println("]");
        } else {
            if (!node.getTextContent().trim().isEmpty()) {
                System.out.println(prefix + node.getTextContent().trim());
            }
        }

        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            prefix = "\t" + prefix;
            printDom(prefix, childNodes.item(i));
            prefix = prefix.substring(1);
        }
        if (node.hasChildNodes()) {
            System.out.println(prefix + "[/" + node.getNodeName() + "]");
        }
    }
}
