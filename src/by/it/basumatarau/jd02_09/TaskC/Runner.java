package by.it.basumatarau.jd02_09.TaskC;

import by.it.basumatarau.jd02_09.beans.Venues;
import java.io.File;

public class Runner {
    public static void main(String[] args) {
        ConverterFactory factory = new ConverterFactory();
        AbstractConverter converter = factory.getConverter(AbstractConverter.Direction.XML_TO_JSON, Venues.class);

        converter.load(new File(getFullPathTo("XML.xml")));
        converter.save(new File(getFullPathTo("JSON.json")));

        converter = factory.getConverter(AbstractConverter.Direction.JSON_TO_XML, Venues.class);

        converter.load(new File(getFullPathTo("JSON.json")));
        converter.save(new File(getFullPathTo("XML2.xml")));
    }

    private static String getFullPathTo(String xmlFileName) {
        String root = System.getProperty("user.dir");
        String srcDir = File.separator + "src" + File.separator;
        return root+
                srcDir+
                Runner.class.getName().replaceAll(Runner.class.getSimpleName(), "").
                        replaceAll("[.]", File.separator)+
                xmlFileName;
    }
}
