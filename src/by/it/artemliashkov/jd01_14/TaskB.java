package by.it.artemliashkov.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {

    private static int countWords = 0;
    private static int countPunctuationMarks=0;

    public static void main(String[] args) {
        String path=System.getProperty("user.dir");
        path=path+"/src/by/it/artemliashkov/jd01_14/";
        String fileName=path+"resultTaskB.txt";
        try (BufferedReader bufferedReader =
                     new BufferedReader(
                             new FileReader(path + "text.txt"))
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
                new FileWriter(fileName))
        ){
            bufferedWriter.print("words=" + countWords + ", punctuation marks=" + countPunctuationMarks);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
