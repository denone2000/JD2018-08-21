package by.it.nesterovich.jd01_15;

import java.io.File;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) {
        String directory = dir(TaskC.class);
        System.out.println(directory);

        Scanner scanner = new Scanner(System.in);
        String line;

        while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
            if (line.equals("dir")) {
                File file = new File(directory);
                File[] listFiles = file.listFiles();
                for (File element : listFiles) {
                    System.out.println(element.getName());
                }
                System.out.println(directory);
            } else if (line.equals("cd ..")) {
                String[] dir = directory.split("\\\\");
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < dir.length - 1; i++) {
                    sb.append(dir[i]).append(File.separator);
                }
                directory = sb.toString();
                System.out.println(directory);

            } else if (line.substring(0, 2).equals("cd")) {
                String stringDirectory = line.substring(3, line.length());
                directory += stringDirectory + File.separator;
                System.out.println(directory);
            } else {
                System.out.println("команда не распознана");
            }
        }
    }

    private static String dir(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = clazz.getName().replace(clazz.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }
}
