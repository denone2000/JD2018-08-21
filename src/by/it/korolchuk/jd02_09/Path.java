package by.it.korolchuk.jd02_09;

class Path {

    private Path() {

    }

    static String getXML() {
        String root = System.getProperty("user.dir");
        return root + "/src/by/it/korolchuk/jd02_09/Persons+XSD.xml";
    }

    static String getXmlResult() {
        String root = System.getProperty("user.dir");
        return root + "/src/by/it/korolchuk/jd02_09/Persons+XSD+generate.xml";

    }
}
