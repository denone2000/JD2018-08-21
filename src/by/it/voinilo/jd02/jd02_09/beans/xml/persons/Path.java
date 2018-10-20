package by.it.voinilo.jd02.jd02_09.beans.xml.persons;

public class Path {
    Path(){}
   static String getXML(){
        String root = System.getProperty("user.dir");
        return root + "/src/by/it/voinilo/jd02/jd02_09/Persons+xsd.xml";
    }
}
