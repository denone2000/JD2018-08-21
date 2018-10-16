package by.it.basumatarau.jd02_09.TaskC;

class ConverterFactory {

    ConverterFactory(){

    }

    AbstractConverter getConverter(AbstractConverter.Direction convType, Class clazz){
        switch (convType){
            case JSON_TO_XML:
                return new JSONtoXMLConvetor(clazz);
            case XML_TO_JSON:
                return new XMLtoJSONconverter(clazz);
        }
        return null;
    }
}
