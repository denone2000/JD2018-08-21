package by.it.artemliashkov.jd01_14;
import java.io.*;
import java.util.ArrayList;

public class TaskC {

    private static ArrayList<String> arrayList = new ArrayList<>();

    public static void main(String[] args) {
        String path=System.getProperty("user.dir");
        path=path+"/src/by/it/artemliashkov";
        String fileName=path+"/jd01_14/resultTaskC.txt";

        getPathDirectories(path);
        for (Object element : arrayList) {
            System.out.println(element);
        }

        try (PrintWriter bufferedWriter = new PrintWriter(
                new FileWriter(fileName))
        ) {
            for (String elem : arrayList) {
                bufferedWriter.println(elem);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getPathDirectories(String dir) {
        File file = new File(dir);
        File[] listFiles = file.listFiles();
        for (File elementListFiles : listFiles) {
            if (elementListFiles.isDirectory()) {
                String directory = "dir:" + elementListFiles.getName();
                arrayList.add(directory);
                getPathDirectories(elementListFiles.getAbsolutePath());
            } else {
                String nameFile = "file:" + elementListFiles.getName();
                arrayList.add(nameFile);
            }
        }
    }

}