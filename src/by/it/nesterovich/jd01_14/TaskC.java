package by.it.nesterovich.jd01_14;

import java.io.*;
import java.util.ArrayList;

public class TaskC {

    private static ArrayList<String> arrayListFiles = new ArrayList<>();
    private static ArrayList<String> arrayListDirectory = new ArrayList<>();

    public static void main(String[] args) {
        String path = System.getProperty("user.dir");
        String fileName = path + "/src/by/it/nesterovich/";

        getAllNameFileAndDirectory(fileName);
        printArrayList(arrayListDirectory);
        printArrayList(arrayListFiles);

        try (PrintWriter bufferedWriter = new PrintWriter(
                new FileWriter(dir(TaskC.class) + "resultTaskC.txt"))
        ) {
            for (String elem : arrayListFiles) {
                bufferedWriter.print(elem);
            }
            for (String elem : arrayListDirectory) {
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
                arrayListDirectory.add(directory);
                //System.out.println("dir:" + elementListFiles.getName());
                getAllNameFileAndDirectory(elementListFiles.getAbsolutePath());
            } else {
                String nameFile = "file:" + elementListFiles.getName();
                arrayListFiles.add(nameFile);
                //System.out.println("file:" + elementListFiles.getName());
            }
        }
    }

    private static String dir(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = clazz.getName().replace(clazz.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }
}
