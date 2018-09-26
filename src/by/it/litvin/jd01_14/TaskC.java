package by.it.litvin.jd01_14;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TaskC {

    private static String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = TaskC.class.getName().replace(TaskC.class.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(dir() + "resultTaskC.txt"))) {
            File file = new File(System.getProperty("user.dir") + File.separator + "src" +
                    File.separator + "by" + File.separator + "it" + File.separator + "litvin" + File.separator);
            File[] files = file.listFiles();
            if (files != null) {
                for (File file1 : files) {
                    System.out.println("dir:" + file1.getName());
                    writer.write("dir:" + file1.getName());

                }
            }
            if (files != null) {
                for (File file1 : files) {
                    File[] files1;
                    files1 = file1.listFiles();
                    assert files1 != null;
                    for (File file2 : files1) {
                        System.out.println("file:" + file2.getName());
                        writer.write("file:" + file2.getName());

                    }

                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
