package by.it.yaroshchuk.jd02_08;

public class Util {

    private Util(){}

    static String xml(){
        String root = System.getProperty("user.dir");
        String xml = root + "/src/by/it/yaroshchuk/jd02_07/resumes.xml";
        return xml;
    }
}
