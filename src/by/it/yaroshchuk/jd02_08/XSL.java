package by.it.yaroshchuk.jd02_08;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class XSL {

    public static void main(String[] args) {

        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(Util.xsl()));
            transformer.transform(new StreamSource(Util.xml()), new StreamResult(Util.path() + "resumes.html"));
            System.out.println("Transform complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + e);
        }
    }
}
