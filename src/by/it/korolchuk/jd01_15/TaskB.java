package by.it.korolchuk.jd01_15;

import java.io.*;
import java.util.ArrayList;


public class TaskB {
    public static void main(String[] args) throws IOException {
        //это однострочный комментарий
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/korolchuk/jd01_15/";
        //это тоже однострочный комментарий
        String src = path + "TaskB.java";
        String fileTxt = path + "TaskB.txt";

        ArrayList<String> lines = new ArrayList<>();
        String[] arr = readFile(src).split("\n");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].contains("/*")) {
                while (!(arr[i].contains("*/") ))
                    i++;
            }
            else if (!(arr[i].contains("//")) || (arr[i].contains("*/"))
            || (arr[i].contains("/*"))) {
                lines.add(arr[i]);
                System.out.println(arr[i]);
            }
        }
        try (FileWriter writer = new FileWriter(fileTxt);
             PrintWriter printer = new PrintWriter(writer)) {
            for (String ln : lines) {
                printer.print(ln);
            }
        }
        System.out.println(lines);
    }

    /*это двустрочный
    комментарий*/
    public static String readFile(String file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
    /*это
    многострочный
    комментарий*/

        /**@Param a это javadoc*/

        try {
            while ((line = reader.readLine()) != null) {

                stringBuilder.append(line);
                stringBuilder.append(ls);
            }

            return stringBuilder.toString();
        } finally {
            reader.close();
        }
    }
}
