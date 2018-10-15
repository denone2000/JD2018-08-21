package by.it.nesterovich.jd02_09.task_c;

import by.it.nesterovich.jd02_09.beans.Films;

public class Runner {

    public static void main(String[] args) {
        ConverterFactory<Films> converterFactory = new ConverterFactory<>();
        converterFactory.getConverter(Direction.XML_TO_JSON, Films.class);
        converterFactory.getConverter(Direction.JSON_TO_XML, Films.class);
    }
}
