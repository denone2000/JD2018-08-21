package by.it.nesterovich.jd02_09.task_c;

import java.io.File;

class ConverterFactory<Bean> {

    Converter getConverter(Direction direction, Class<Bean> beanClass) {
        Converter<Bean> converter = null;
        switch (direction) {
            case XML_TO_JSON: {
                converter = new ConverterXmlToJson<>(beanClass);
                File file = new File(Path.getPathFile("Films+XSD.xml"));
                System.out.println(">>>>>>>>>>>>>>> XML <<<<<<<<<<<<<<<<");
                System.out.println(ReadFile.readFile(file));
                converter.load(file);
                File resultFile = new File(Path.getPathFile("resultJSON.json"));
                converter.save(resultFile);
                System.out.println(">>>>>>>>>>>>>>> JSON from XML <<<<<<<<<<<<<<<<");
                System.out.println(ReadFile.readFile(resultFile));
                break;
            }
            case JSON_TO_XML: {
                converter = new ConverterJsonToXml<>(beanClass);
                File file = new File(Path.getPathFile("resultJSON.json"));
                String text = ReadFile.readFile(file);
                System.out.println(">>>>>>>>>>>>>>> JSON <<<<<<<<<<<<<<<<");
                System.out.println(text);
                converter.load(text);
                File resultFile = new File(Path.getPathFile("resultXML.xml"));
                converter.save(resultFile);
                System.out.println(">>>>>>>>>>>>>>> XML from JSON <<<<<<<<<<<<<<<<");
                System.out.println(ReadFile.readFile(resultFile));
                break;
            }
            default: {
                System.out.println("Конвектор не распознан");
                break;
            }
        }
        return converter;
    }
}
