package by.it.nesterovich.jd02_09.task_c;

class Path {

    private Path() {
    }

    static String getPathFile(String nameFile) {
        String root = System.getProperty("user.dir") + "/src/by/it/nesterovich/jd02_09/task_c/";
        return root + nameFile;
    }

    static String getXmlResultC(String nameFile) {
        String root = System.getProperty("user.dir") + "/src/by/it/nesterovich/jd02_09/";
        return root + nameFile;
    }
}
