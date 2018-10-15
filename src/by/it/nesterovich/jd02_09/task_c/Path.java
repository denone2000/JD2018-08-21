package by.it.nesterovich.jd02_09.task_c;

class Path {

    static String getPathFile(String nameFile) {
        String root = System.getProperty("user.dir") + "/src/by/it/nesterovich/jd02_09/task_c/";
        return root + nameFile;
    }
}
