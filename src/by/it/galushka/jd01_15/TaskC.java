package by.it.galushka.jd01_15;

import java.io.File;
import java.util.Scanner;

public class TaskC {
    
    private static String actualDir = getDirectory(TaskC.class);

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String inputLine;
        while (!(inputLine = scanner.nextLine()).equalsIgnoreCase("end")){
            if (inputLine.contains("cd")) {
                cdMethod(inputLine);
            } else if (inputLine.equals("dir")) {
                dirMethod();
            } else {
                System.out.println("Вы ввели неверную команду!");
            }
        }
    }

    private static void dirMethod() {
        File files = new File(actualDir);
        File[] listFiles = files.listFiles();
        for (File listFile : listFiles) {
            System.out.println(listFile.getName());
        }
    }
    
    private static void cdMethod(String inputLine) {
        if (inputLine.equals("cd ..")) {
            getActualDirBack();
        }
        else
            cdFolderName(inputLine);
    }

    private static void cdFolderName(String inputLine) {
        inputLine = inputLine.replace("cd ", "");
        File directory = new File(actualDir);
        File[] folders = directory.listFiles();
        for (File folder : folders) {
            String folderName = folder.toString().replace(actualDir, "");
            if (folderName.equals(inputLine)) {
                getActualDirNext(inputLine);
                break;
            }
        }
    }
    
    private static String getDirectory(Class<?> clss) {
        StringBuilder path = new StringBuilder();
        String dir = clss.getName().replace(".", File.separator).replace(clss.getSimpleName(), "");
        path.append(System.getProperty("user.dir")).append(File.separator);
        path.append("src" + File.separator).append(dir);
        return path.toString();
    }

    private static void getActualDirNext(String inputLine) {
        actualDir = actualDir + inputLine + File.separator;
        System.out.println(actualDir);
    }

    private static void getActualDirBack() {
        StringBuilder sb = new StringBuilder();
        String[] folders = actualDir.split("\\\\");
        for (int i = 0; i < folders.length-1; i++) {
            sb.append(folders[i]).append(File.separator);
        }
        actualDir = sb.toString();
        System.out.println(actualDir);
    }
}
