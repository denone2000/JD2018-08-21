package by.it.bindyuk.jd02_07;

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
        String xml = System.getProperty("user.dir").concat("/src/by/it/bindyuk/jd02_07/Transport+XSD.xml");
        String xsd = System.getProperty("user.dir").concat("/src/by/it/bindyuk/jd02_07/Transport.xsd");
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(lang);
        try {
            Schema schema = factory.newSchema(new File(xsd));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xml);
            validator.validate(source);
            System.out.println("Validation is OK!");
        } catch (SAXException | IOException e) {
            System.out.println("INVALID VALIDATION");
            e.printStackTrace();
        }
    }
}
