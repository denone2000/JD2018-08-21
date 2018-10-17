package by.it.korolchuk.jd02_08;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import static by.it.korolchuk.jd02_08.Util.*;

public class Transformer {
    public static void main(String[] args) {
        String inputFile = root() + "Theatres.xml";
        String outputFile = root() + "XSLT.html";
        String xsl = root() + "XSLT.xsl";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer(new StreamSource(xsl));
            transformer.transform(new StreamSource(inputFile), new StreamResult(outputFile));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
