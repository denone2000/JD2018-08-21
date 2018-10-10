package by.it.nesterovich.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static int countWords = 0;
    private static int countPunctuationMarks;

    public static void main(String[] args) {

        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new FileReader(dir(TaskB.class) + "text.txt"))
        ) {
            StringBuilder text = new StringBuilder();
            String line = bufferedReader.readLine();
            while (line != null) {
                text.append(line).append("\n");
                line = bufferedReader.readLine();
            }
            Pattern patternWords = Pattern.compile("[а-яА-ЯёЁ]+");
            Matcher matcherWords = patternWords.matcher(text);
            while (matcherWords.find()) {
                countWords++;
            }
            Pattern patternPunctuation = Pattern.compile("([-?!,:])|(\\.{1,3})");
            Matcher matcherPunctuation = patternPunctuation.matcher(text);
            while (matcherPunctuation.find()) {
                countPunctuationMarks++;
            }
            System.out.println("words=" + countWords + ", punctuation marks=" + countPunctuationMarks);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (PrintWriter bufferedWriter = new PrintWriter(
                new FileWriter(dir(TaskB.class) + "resultTaskB.txt"))
        ){
            bufferedWriter.print("words=" + countWords + ", punctuation marks=" + countPunctuationMarks);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String dir(Class<?> clazz) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String classDir = clazz.getName().replace(clazz.getSimpleName(), "").replace(".", File.separator);
        return path + classDir;
    }
}
