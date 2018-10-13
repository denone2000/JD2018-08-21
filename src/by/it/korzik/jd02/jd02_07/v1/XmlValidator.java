package by.it.korzik.jd02.jd02_07.v1;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidator {
    public static void main(String[] args) {
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        String path = System.getProperty("user.dir");
        path = path +"/src/by/it/korzik/jd02/jd02_07/v1/";
        String xsdPath = path+"Persons+XSD.xml";
        String xsdFilePath = path+"Persons_XSD.xsd";
        SchemaFactory schemaFactory = SchemaFactory.newInstance(lang);
        try {
            Schema schema = schemaFactory.newSchema(new File(xsdFilePath));
            Validator validator = schema.newValidator();
            StreamSource streamSource = new StreamSource(xsdPath);
            validator.validate(streamSource);
            System.out.println("Все работает");
        } catch (SAXException e) {
            System.out.println("ошибка");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
