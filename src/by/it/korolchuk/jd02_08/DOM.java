package by.it.korolchuk.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DOM {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        Document document = documentBuilder.parse(Util.xml());
        Element element = document.getDocumentElement();
        printResult("", element);
    }

    private static void printResult(String prefix, Node node) {
        if (node.hasChildNodes()) {
            System.out.print(prefix + "<" + node.getNodeName());
            if (node.hasAttributes()) {
                NamedNodeMap attributes = node.getAttributes();
                for (int i = 0; i < attributes.getLength(); i++) {
                    System.out.print(" " + attributes.item(i).getNodeName() + " = " + attributes.item(i).getNodeValue());
                }
            }
            System.out.println(">");
        } else {
            if (!node.getTextContent().trim().isEmpty()) {
                System.out.println(prefix + node.getTextContent().trim());
            }
        }
        NodeList nodeList = node.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            prefix = "\t" + prefix;
            printResult(prefix, nodeList.item(i));
            prefix = prefix.substring(1);
        }
        if (node.hasChildNodes()) {
            System.out.println(prefix + "</" + node.getNodeName() + ">");
        }
    }
}
