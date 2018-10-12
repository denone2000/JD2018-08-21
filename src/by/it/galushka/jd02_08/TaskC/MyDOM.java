package by.it.galushka.jd02_08.TaskC;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class MyDOM {

    public static void main(String[] args) {
        String file = System.getProperty("user.dir");
        file = file.replace("\\", "/") + "/src/by/it/galushka/jd02_08/Fighters.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document parse = builder.parse(file);
            Element el = parse.getDocumentElement();
            printDom(el);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }

//    private static String tab = "";

    private static void printDom(Node node) {
        NodeList childNodes = node.getChildNodes();
        System.out.println(childNodes.getLength());
        System.out.println(childNodes.item(3));
//        String value = node.getNodeValue();
//        if (value != null && value.length() > 0) {
//            System.out.println("> " + value.trim());
//            System.out.println("</" + node.getLocalName() + ">");
//        }
//        NodeList nodes = node.getChildNodes();
//        for (int i = 0; i < nodes.getLength(); i++) {
//            Node item = nodes.item(i);
//            if (i % 2 != 0) {
//                System.out.print(item.getNodeName());
//            }
//            printDom(item);
//        }
    }


//    private static void printDom(String prefix, Node node) {
//        String value = node.getNodeValue();
//        if (value != null) {
//            System.out.println(prefix + value.trim());
//        }
//        NodeList childNodes = node.getChildNodes();
//        for (int i = 0; i < childNodes.getLength(); i++) {
//            printDom("<" + node.getNodeName() + ">", childNodes.item(i));
//        }
//    }
}
