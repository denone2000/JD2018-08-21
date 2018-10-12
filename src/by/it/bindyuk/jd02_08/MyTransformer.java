package by.it.bindyuk.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class MyTransformer {
    private static final String root = System.getProperty("user.dir").concat("/src/by/it/bindyuk/jd02_08/");

    public static void main(String[] args) {
        String get = root + "Transport.xml";
        String set = root + "xpath.html";
        String xsl = root + "xpath.xsl";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(xsl));
            transformer.transform(new StreamSource(get), new StreamResult(set));
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
