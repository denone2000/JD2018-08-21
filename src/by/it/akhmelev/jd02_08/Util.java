package by.it.akhmelev.jd02_08;

public class Util {

    private Util() {
    }

    static String xml() {
        String root = System.getProperty("user.dir");
        String xml = "/src/by/it/akhmelev/jd02_07/Persons+XSD.xml";
        return root + xml;
    }
}


