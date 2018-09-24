package by.it.korolchuk.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) throws IOException {
        ArrayList<String> words = new ArrayList<>();
        ArrayList<String> punctSigns = new ArrayList<>();

        String path = System.getProperty("user.dir");
        path = path + "/src/by/it/korolchuk/jd01_14/";
        String src = path + ("text.txt");
        String fileOut = path + "resultTaskB.txt";

        try (FileReader fileReader = new FileReader(src);
        BufferedReader bufReader = new BufferedReader(fileReader)) {
            while (bufReader.ready()) {
                String text = bufReader.readLine();
                Pattern pattern = Pattern.compile("[А-Яа-яЁё]+");
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {
                    String word = matcher.group();
                    words.add(word);
                }
            }
        }

        try (FileReader fileReader = new FileReader(src);
             BufferedReader bufReader = new BufferedReader(fileReader)) {
            while (bufReader.ready()) {
                String text = bufReader.readLine();
                Pattern pattern = Pattern.compile("[^А-Яа-яЁё\\s]+");
                Matcher matcher = pattern.matcher(text);
                while (matcher.find()) {
                    String sign = matcher.group();
                    punctSigns.add(sign);
                }
            }
        }

        try (FileWriter writer = new FileWriter(fileOut);
             PrintWriter printer = new PrintWriter(writer);) {
            printer.print("words=" + words.size() + "," + "punctuation marks=" + punctSigns.size());
        }
        System.out.printf("words=%d,punctuation marks=%d",words.size(),punctSigns.size());
    }
}
