package by.it.nesterovich.jd01_15;

import java.io.File;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class TaskB {
    /*
    * this method main
    */
    public static void main(String[] args) {        //comment start main
        try (BufferedReader bufferedReader = new BufferedReader(
                new FileReader(dir(TaskB.class) + "TaskB.java"));
             PrintWriter printWriter = new PrintWriter(
                     new FileWriter(dir(TaskB.class) + "TaskB.txt"))
        ) {
            StringBuilder text = new StringBuilder();
            boolean comment = false;
            String line = bufferedReader.readLine();
            /*
             comment
            */
            while (line != null) {
                if (line.contains(ClassComment.START_COMMENT)) {
                    comment = true;
                    int index = line.indexOf(ClassComment.SLASH);
                    text.append(line.substring(0, index));
                    line = bufferedReader.readLine();
                } else if (line.contains(ClassComment.END_COMMENT) && comment ) {
                    text.append("\n");
                    comment = false;
                    line = bufferedReader.readLine();
                } else if (line.contains(ClassComment.STAR) && comment) {
                    line = bufferedReader.readLine();
                } else if (line.contains(ClassComment.ONE_COMMENT)) {
                    int index = line.lastIndexOf(ClassComment.ONE_COMMENT);
                    text.append(line.substring(0, index)).append("\n");
                    line = bufferedReader.readLine();
                } else if (comment) {
                    line = bufferedReader.readLine();
                } else {
                    text.append(line).append("\n");
                    line = bufferedReader.readLine();
                }
            }
            System.out.println(text);
            printWriter.print(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //comment end main
    /**
     * method to get the full path to the class
     *
     * @param clazz - name class
     * @return - path to class
     */
    private static String dir(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = clazz.getName().replace(clazz.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }
}
