package by.it.akhmelev.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class MyValidator {
    public static void main(String[] args) {

        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String root = System.getProperty("user.dir");
        String xml = root + "/src/by/it/akhmelev/jd02_07/Companies+XSD.xml";
        String xsd = root + "/src/by/it/akhmelev/jd02_07/Companies.xsd";
        SchemaFactory factory = SchemaFactory.newInstance(lang);
        try {
            Schema schema = factory.newSchema(new File(xsd));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xml);
            validator.validate(source);
            System.out.println("OK");
        } catch (SAXException e) {
            System.out.println("Invalid");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
