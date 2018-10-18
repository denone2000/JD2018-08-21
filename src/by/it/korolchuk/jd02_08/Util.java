package by.it.korolchuk.jd02_08;

public class Util {

    private Util() {

    }

    static String xml() {
        String root = System.getProperty("user.dir");
        String xml = "/src/by/it/korolchuk/jd02_07/Persons+XSD";
        return root + xml;
    }


    static String root() {
        return System.getProperty("user.dir").concat("/src/by/it/korolchuk/jd02_08/");
    }
}
