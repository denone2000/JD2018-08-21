package by.it.korolchuk.jd01_14;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;


public class TaskC {
    public static void main(String[] args) throws Exception {

        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/korolchuk/";
        File rootDir = new File(path);
        String fileOut = path + "jd01_14/resultTaskC.txt";

        List<String> result = new ArrayList<>();
        Queue<File> fileTree = new PriorityQueue<>();

        Collections.addAll(fileTree, Objects.requireNonNull(rootDir.listFiles()));

        try (FileWriter writer = new FileWriter(fileOut);
             PrintWriter printer = new PrintWriter(writer)) {

            while (!fileTree.isEmpty()) {
                File currentFile = fileTree.remove();
                if (currentFile.isDirectory()) {
                    System.out.println("dir:" + currentFile.getName());
                    printer.print("dir:" + currentFile.getName() + "\n");
                    Collections.addAll(fileTree, Objects.requireNonNull(currentFile.listFiles()));
                } else {
                    System.out.println("file:" + currentFile.getName());
                    printer.print("file:" + currentFile.getName() + "\n");
                    result.add(currentFile.getName());
                }
            }
        }
    }
}
