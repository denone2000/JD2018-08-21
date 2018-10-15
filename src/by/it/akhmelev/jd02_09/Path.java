package by.it.akhmelev.jd02_09;

public class Path {

    private Path() {
    }

    static String getXml(){
        String root = System.getProperty("user.dir");
        return root+"/src/by/it/akhmelev/jd02_09/Persons+XSD.xml";

    }

    static String getXmlResult(){
        String root = System.getProperty("user.dir");
        return root+"/src/by/it/akhmelev/jd02_09/Persons+XSD+generate.xml";

    }
}
