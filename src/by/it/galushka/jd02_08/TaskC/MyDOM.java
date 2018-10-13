package by.it.galushka.jd02_08.TaskC;

import org.w3c.dom.*;
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

    private static String tab = "";

    private static void printDom(Node node) {
        switch (node.getNodeType()) {
            case Node.ELEMENT_NODE:
                System.out.print(tab + "<" + node.getNodeName());
                if (node.hasAttributes()) {
                    NamedNodeMap attributes = node.getAttributes();
                    for (int i = 0; i < attributes.getLength(); i++) {
                        Node item = attributes.item(i);
                        System.out.print(" " + item);
                    }
                }
                System.out.println(">");
                tab = tab + "\t";
                break;
            case Node.TEXT_NODE:
                String textContent = node.getTextContent().trim();
                if (textContent.length() > 0)
                    System.out.println(tab + textContent);
                break;
        }
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            printDom(childNodes.item(i));
        }
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            tab = tab.substring(1);
            System.out.println(tab + "</" + node.getNodeName() + ">");

        }
    }
}
