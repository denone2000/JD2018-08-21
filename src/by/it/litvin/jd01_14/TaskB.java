package by.it.litvin.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static String dir() {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String clDir = TaskB.class.getName().replace(TaskB.class.getSimpleName(), "").replace(".", File.separator);
        return path + clDir;
    }

    public static void main(String[] args) {


        try (BufferedReader words = new BufferedReader(new FileReader(dir() + "text.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter(dir() + "resultTaskB.txt"))
        ) {

            StringBuilder text = new StringBuilder();
            String line = words.readLine();
            while (line != null) {
                text.append(line).append("\n");
                line = words.readLine();

            }
            int countWords = 0;
            int countMarks = 0;
            Pattern patternWords = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matcherWords = patternWords.matcher(text);
            while (matcherWords.find()) {
                countWords++;
            }

            Pattern pattern = Pattern.compile("[-,!:?.]+");
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                countMarks++;
            }
            System.out.println("words=" + countWords + " marks=" + countMarks);
            writer.write("words=" + countWords + " marks=" + countMarks);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

