package by.it.nesterovich.jd02_09.task_c;

import by.it.nesterovich.jd02_09.beans.Films;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;

class ConverterJsonToXml<Bean> extends Converter<Bean> {

    private static Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();

    ConverterJsonToXml(Class<Bean> beanClass) {
        super(beanClass);
    }

    @Override
    String getText() {
        Marshaller marshaller;
        try {
            JAXBContext context = JAXBContext.newInstance(Films.class);
            marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(getBean(), new File(Path.getPathFile("resultXML.xml")));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return ReadFile.readFile(new File(Path.getPathFile("resultXML.xml")));
    }

    @Override
    void load(String text) {
        Bean bean = (Bean) gson.fromJson(text, Films.class);
        setBean(bean);
    }
}
