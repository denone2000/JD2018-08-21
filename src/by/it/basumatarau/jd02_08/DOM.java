package by.it.basumatarau.jd02_08;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DOM {

    public static void main(String[] args) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        try (InputStream inputStream = new FileInputStream(getXmlFileName("Venues.xml"))){
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputStream);

            Element el = doc.getDocumentElement();
            pritntDocumentSubtree("", el);

        } catch (ParserConfigurationException | IOException | SAXException e) {
            e.printStackTrace();
        }
    }

    private static void pritntDocumentSubtree(String offset, Node el) {

        switch (el.getNodeType()){
            case Node.ELEMENT_NODE:
                System.out.print(offset+"<"+el.getNodeName());

                if(el.hasAttributes()) {
                    for (int i = 0; i < el.getAttributes().getLength(); i++) {
                        System.out.print(" " + el.getAttributes().item(i).getNodeName() +
                                "=\"" + el.getAttributes().item(i).getNodeValue() + "\"");
                    }
                }
                System.out.println(">");
                break;
            case Node.TEXT_NODE:
                if(el.getTextContent().trim().length()>0) {
                    System.out.println(offset + el.getTextContent().trim());
                }
                break;
        }

        for (int i = 0; i < el.getChildNodes().getLength(); i++) {
            pritntDocumentSubtree(offset+'\t', el.getChildNodes().item(i));
        }

        switch (el.getNodeType()) {
            case Node.TEXT_NODE:
                //System.out.println("text..");
                break;
            case Node.ELEMENT_NODE:
                System.out.println(offset+"</"+el.getNodeName()+">");
                break;
        }

    }

    private static String getXmlFileName(String xmlFileName) {
        String root = System.getProperty("user.dir");
        String srcDir = File.separator + "src" + File.separator;
        return root+
                srcDir+
                DOM.class.getName().replaceAll(DOM.class.getSimpleName(), "").
                        replaceAll("[.]", File.separator)+
                xmlFileName;
    }
}
