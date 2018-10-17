package by.it.galushka.jd02_09;

public class Path {

    private Path() {
    }

    static String getXML(){
        String root = System.getProperty("user.dir");
        return root + "/src/by/it/galushka/jd02_09/Fighters+XSD.xml";
    }

    static String getXMLResult(String fileName){
        String root = System.getProperty("user.dir");
        return root + "/src/by/it/galushka/jd02_09/" + fileName;
    }
}
