package by.it.bindyuk.jd02_09;

public class MyPath {
    private MyPath() {
    }

    static String getMyXml() {
        String root = System.getProperty("user.dir");
        return root + "/src/by/it/bindyuk/jd02_09/Transport+XSD.xml";
    }

    static String getXmlResult() {
        String root = System.getProperty("user.dir");
        return root + "/src/by/it/bindyuk/jd02_09/Transport+XSD+generate.xml";
    }
}
