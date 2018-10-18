package by.it.yaroshchuk.jd02_09;

public class Path {

    private Path(){}

    static String getXml(){
        String root = System.getProperty("user.dir");
        return root + "/src/by/it/yaroshchuk/jd02_09/resumes+XSD.xml";
    }
}
