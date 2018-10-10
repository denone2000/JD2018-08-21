package by.it.basumatarau.jd02_07;

import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XMLValidator {
    public static void main(String[] args) {

        String nsUri = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String path = System.getProperty("user.dir")+File.separator + "src" +File.separator
                + XMLValidator.class.getName().replaceAll("[.]", File.separator).
                replace(XMLValidator.class.getSimpleName(),"");

        String xmlPath = path + "Venues_XSD.xml";
        String xsdPath = path + "Venues.xsd";

        SchemaFactory factory = SchemaFactory.newInstance(nsUri);
        try {
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlPath);
            validator.validate(source);
            System.out.printf("%s has been validated...\n", xmlPath);
        } catch (SAXException e) {
            System.out.printf("%s is invalid...\n", xmlPath);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
