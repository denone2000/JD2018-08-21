package by.it.artemliashkov.jd01_14;

import java.io.*;
import java.util.ArrayList;

public class TaskC1 {
    private static ArrayList<String> arrayListFilesAndDirectory = new ArrayList<>();

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        String fileName = path + "/src/by/it/artemliashkov/";

        getAllNameFileAndDirectory(fileName);
        printArrayList(arrayListFilesAndDirectory);

        try (PrintWriter bufferedWriter = new PrintWriter(
                new FileWriter(dir(TaskC.class) + "resultTaskC.txt"))
        ) {
            for (String elem : arrayListFilesAndDirectory) {
                bufferedWriter.print(elem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printArrayList(ArrayList<?> arrayList) {
        for (Object element : arrayList) {
            System.out.println(element);
        }
    }

    public static void getAllNameFileAndDirectory(String dir) {
        File file = new File(dir);
        File[] listFiles = file.listFiles();
        for (File elementListFiles : listFiles) {
            if (elementListFiles.isDirectory()) {
                String directory = "dir:" + elementListFiles.getName();
                arrayListFilesAndDirectory.add(directory);
                getAllNameFileAndDirectory(elementListFiles.getAbsolutePath());
            } else {
                String nameFile = "file:" + elementListFiles.getName();
                arrayListFilesAndDirectory.add(nameFile);
            }
        }
    }

    private static String dir(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = clazz.getName().replace(clazz.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }
}
