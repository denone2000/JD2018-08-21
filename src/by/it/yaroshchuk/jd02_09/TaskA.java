package by.it.yaroshchuk.jd02_09;

import by.it.yaroshchuk.jd02_09.bean.Resumes;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class TaskA {
    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Resumes.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Object unmarshal = unmarshaller.unmarshal(new File(Path.getXml()));
            Resumes resumes = (Resumes) unmarshal;
            System.out.println(resumes);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
