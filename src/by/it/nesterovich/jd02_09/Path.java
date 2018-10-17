package by.it.nesterovich.jd02_09;

class Path {

    private Path() {
    }

    static String getXml(String nameFile) {
        String root = System.getProperty("user.dir")+"/src/by/it/nesterovich/jd02_09/";
        return root + nameFile;
    }

    static String getXmlResult(String nameFile) {
        String root = System.getProperty("user.dir")+ "/src/by/it/nesterovich/jd02_09/";
        return root + nameFile;
    }
}
