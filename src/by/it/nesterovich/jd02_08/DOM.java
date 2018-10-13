package by.it.nesterovich.jd02_08;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class DOM {

    public static void main(String[] args) {

        String fileName = "src/by/it/nesterovich/jd02_07/Films+XSD.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(fileName);
            Element el = doc.getDocumentElement();
            printDom("", el);
        } catch (Exception e) {
            System.out.print("Ошибка!  " + e.toString());
        }
    }

    private static void printDom(String prefix, Node node) {
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.print(prefix + "<" + node.getNodeName());
            if (node.hasAttributes()) {
                NamedNodeMap list = node.getAttributes();
                for (int i = 0; i < list.getLength(); i++) {
                    System.out.print(" " + list.item(i).getNodeName() + "=\"" + list.item(i).getNodeValue() + "\"");
                }
            }
            System.out.println(">");
        } else {
            if (node.getTextContent().trim().length() > 0) {
                System.out.println(prefix + node.getTextContent().trim());
            }
        }
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(prefix + "\t", children.item(i));
        }
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(prefix + "</" + node.getNodeName() + ">");
        }
    }
}
