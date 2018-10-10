package by.it.bindyuk.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir(TaskC.class) + "resultTaskC.txt"))) {


            File file = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "by" + File.separator + "it" +
                    File.separator + "bindyuk" + File.separator);
            File[] files = file.listFiles();
            for (File file1 : files) {
                String name = file1.getName();
                System.out.println("dir:" + name);
                writer.write("dir:" + name);
            }
            for (File file1 : files) {
                File[] files1 = file1.listFiles();
                for (File file2 : files1) {
                    System.out.println("file:" + file2.getName());
                    writer.write("file:" + file2.getName());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
