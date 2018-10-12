package by.it.basumatarau.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XMLtoHTMLtransformer {

    public static void main(String[ ] args) {
        String fileName=getXmlFileName("Venues.xml");
        String fileHTML=getXmlFileName("Venues.html");

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(getXmlFileName("VenuesXMLtoHTML.xsl")));

            transformer.transform(new StreamSource(fileName),
                    new StreamResult(fileHTML));

            System.out.println("success!");
        } catch(TransformerException e) {
            System.err.println("fail: " + e);
        }
    }

    private static String getXmlFileName(String xmlFileName) {
        String root = System.getProperty("user.dir");
        String srcDir = File.separator + "src" + File.separator;
        return root+
                srcDir+
                XMLtoHTMLtransformer.class.getName().replaceAll(XMLtoHTMLtransformer.class.getSimpleName(), "").
                        replaceAll("[.]", File.separator)+
                xmlFileName;
    }
}
