package by.it.voinilo.jd02.jd02_07;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class validator {
    public static void main(String[] args) {
        String sname = "/home/dmitriy/IdeaProjects/JD2018-08-21/src/by/it/voinilo/jd02/jd02_07/Persons.xsd";
        String xmlfile = "/home/dmitriy/IdeaProjects/JD2018-08-21/src/by/it/voinilo/jd02/jd02_07/Persons+xsd.xml";
        String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory factory = SchemaFactory.newInstance(lang);
        File schemalocation = new File(sname);
        try {
            Schema schema = factory.newSchema(schemalocation);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlfile);


            validator.validate(source);
            System.out.println("VALIDATION SUCCESFUL");
        } catch (SAXException | IOException e) {
            System.out.println("INVALID");
            e.printStackTrace();
        }
    }
}
