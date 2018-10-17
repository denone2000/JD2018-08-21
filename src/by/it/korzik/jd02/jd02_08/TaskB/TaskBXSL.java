package by.it.korzik.jd02.jd02_08.TaskB;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class TaskBXSL {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        path = path+"/src/by/it/korzik/jd02/jd02_08/TaskB/";
        try {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer(new StreamSource(new File(path + "Persons_XSL.xsl")));
            transformer.transform(new StreamSource(new File(path+"Persons.xml")),new StreamResult(path+"Persons.html"));
            System.out.println("Transform complete");
        } catch (TransformerException e) {
            System.out.println("EROR");
        }
    }
}
