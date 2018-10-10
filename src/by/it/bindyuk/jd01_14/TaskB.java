package by.it.bindyuk.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static String dir(Class<?> cl) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = cl.getName().replace(cl.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        try (BufferedReader words = new BufferedReader(new FileReader(dir(TaskB.class) + "text.txt"));
             BufferedWriter outText = new BufferedWriter(new FileWriter(dir(TaskB.class) + "resultTaskB.txt"))
        ) {
            while (words.ready()) {
                String a = words.readLine();
                list.add(a);
            }
            int sumWords = 0;
            for (String word : list) {
                String[] abc = word.split("[-\\s,\\.!]+");
                int length = abc.length;
                sumWords += length;
            }

            int count = 0;

            StringBuilder sb = new StringBuilder();
            for (String s : list) {
                sb.append(s);
            }
            Pattern pattern = Pattern.compile("[-,\\.:!?]+");
            Matcher matcher = pattern.matcher(sb);
            while (matcher.find()) {
                count++;
            }
            System.out.println("words=" + sumWords + ", punctuation marks=" + count);
            outText.write("words=" + sumWords + ", punctuation marks=" + count);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
