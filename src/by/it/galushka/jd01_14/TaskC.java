package by.it.galushka.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskC {

    public static void main(String[] args) {
        String dir = getDirectory(TaskC.class);
        String path = dir.replace("jd01_14\\", "");
        List<String> folders = getFoldres(path);
        List<String> files = getFiles(folders);
        printResult(folders, files);
    }

    private static List<String> getFiles(List<String> folders) {
        List<String> filesList = new ArrayList<>();
        for (String folder : folders) {
            File files = new File(folder);
            File[] file = files.listFiles();
            for (File element : file) {
                filesList.add(element.toString());
            }
        }
        return filesList;
    }

    private static void printResult(List<String> folders, List<String> files) {
        String pathForCreateFile = getDirectory(TaskC.class);
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(
                             new FileWriter(pathForCreateFile + "resultTaskC.txt")
                     )
        ) {
            String directory = pathForCreateFile.replace("\\jd01_14\\", "");
            System.out.println("В директории " + "\"" +
                    directory + "\" находятся следующие папки и файлы:");
            for (String dir : folders) {
                String folder = dir.replace(directory + "\\", "");
                System.out.println("dir:" + folder);
                bufferedWriter.write("dir:" + folder + "\n");
                for (String myFile : files) {
                    if (myFile.contains(dir)) {
                        String file = myFile.replace(directory
                                + "\\" + folder + "\\", "");
                        System.out.println("file:" + file);
                        bufferedWriter.write("file:" + file + "\n");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<String> getFoldres(String path) {
        List<String> list = new ArrayList<>();
        File myFolders = new File(path);
        File[] myFiles = myFolders.listFiles();
        for (File file : myFiles) {
            File folder = new File(file.toString());
            list.add(folder.toString());
        }
        return list;
    }

    private static String getDirectory(Class<?> clss) {
        StringBuilder path = new StringBuilder();
        String dir = clss.getName().replace(".", File.separator).replace(clss.getSimpleName(), "");
        path.append(System.getProperty("user.dir")).append(File.separator);
        path.append("src" + File.separator).append(dir);
        return path.toString();
    }
}
