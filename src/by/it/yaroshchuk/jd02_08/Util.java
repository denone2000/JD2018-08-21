package by.it.yaroshchuk.jd02_08;

public class Util {

    private Util(){}

    static String root() {
        return System.getProperty("user.dir");
    }

    static String xml(){
        return  path() + "resumes.xml";
    }

    static String xsl(){
        return  path() + "XSL.xml";
    }

    static String path(){
        return root() + "/src/by/it/yaroshchuk/jd02_08/";
    }
}
