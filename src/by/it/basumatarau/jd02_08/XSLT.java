package by.it.basumatarau.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XSLT {
    public static void main(String[] args) {
        TransformerFactory factory = TransformerFactory.newInstance();

        try {
            Transformer transformer = factory.newTransformer(
                    new StreamSource(getXmlFileName("VenuesXMLtoHTML.xsl"))
            );
            transformer.transform(new StreamSource(getXmlFileName("Venues.xml")),
                    new StreamResult(getXmlFileName("Venues.html"))
            );
            System.out.println("success!");
        } catch (TransformerException e) {
            System.out.println("xml to html transformation failed...");
            e.printStackTrace();
        }

    }
    private static String getXmlFileName(String xmlFileName) {
        String root = System.getProperty("user.dir");
        String srcDir = File.separator + "src" + File.separator;
        return root+
                srcDir+
                XSLT.class.getName().replaceAll(XSLT.class.getSimpleName(), "").
                        replaceAll("[.]", File.separator)+
                xmlFileName;
    }
}
