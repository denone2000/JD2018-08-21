package by.it.galushka.jd02_08.TaskB;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class MyXLS {
    public static void main(String[] args) {
        String file = System.getProperty("user.dir");
        String fileXSL = file.replace("\\", "/") + "/src/by/it/galushka/jd02_08/TaskB/xpath.xsl";
        String fileXML = file.replace("\\", "/") + "/src/by/it/galushka/jd02_08/Fighters.xml";
        String fileHTML = file.replace("\\", "/") + "/src/by/it/galushka/jd02_08/TaskB/Fighters.html";
        try {
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(fileXSL));
            transformer.transform(new StreamSource(fileXML), new StreamResult(fileHTML));
            System.out.println("Complete.");
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
