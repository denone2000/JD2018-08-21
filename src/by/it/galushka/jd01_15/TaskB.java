package by.it.galushka.jd01_15;

import java.io.*;

public class TaskB {

    //this is main method
    public static void main(String[] args) {
        //create StringBuilder
        StringBuilder sb = new StringBuilder();
        String pathToFile = getDirectory(TaskB.class) + "TaskB.java";
        readJavaFile(pathToFile);
    }

    private static void readJavaFile(String pathToFile) {
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(pathToFile))
        ) {
            while(reader.ready()) {
                String line = reader.readLine();
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String getDirectory(Class<?> clss) {
        StringBuilder path = new StringBuilder();
        String dir = clss.getName().replace(".", File.separator).replace(clss.getSimpleName(), "");
        path.append(System.getProperty("user.dir")).append(File.separator);
        path.append("src" + File.separator).append(dir);
        return path.toString();
    }
}
