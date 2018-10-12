package by.it.nesterovich.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSLTRunner {

    public static void main(String[] args) {
        String root = System.getProperty("user.dir") + "/src/by/it/nesterovich/jd02_08/";
        String fileName = root + "Films.xml";
        String fileHTML = root + "Films.html";
        String fileTransformer = root + "XSLT.xsl";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(fileTransformer));
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(fileHTML));
            System.out.println("Transform " + fileName + " complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e);
        }
    }
}

