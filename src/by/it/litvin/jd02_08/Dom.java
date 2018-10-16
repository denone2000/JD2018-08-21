package by.it.litvin.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
public class Dom {
    public static void main(String[] args) {

        String fileName = "src/by/it/litvin/JD02_07/Dota+XSD.xml";
        //создадим фабрику и стандартный парсер
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder=factory.newDocumentBuilder();
            Document doc=builder.parse(fileName);
            Element el=doc.getDocumentElement();
            printDom("", el);
        } catch (Exception e) {
            System.out.print("Ошибка! " + e.toString());
        }
    }

    private static void printDom(String prefix, Node node) {
        String tab="\t";
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            System.out.println(prefix + "<" + node.getNodeName()+">");
        }
        else {
            if (node.getTextContent().trim().length()>0){
                System.out.println(prefix+node.getTextContent().trim());
            }
        }
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            printDom(prefix+tab, children.item(i));
        }
        if (node.getNodeType()==Node.ELEMENT_NODE){
            System.out.println(prefix+"</"+node.getNodeName()+">");
        }
    }
}

