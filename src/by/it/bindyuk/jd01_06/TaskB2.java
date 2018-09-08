package by.it.bindyuk.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static String[] sentences = {};

    public static void main(String[] args) {
        Pattern crops = Pattern.compile("\\.{3}");
        Matcher cropper = crops.matcher(Poem.text);
        String s1 = cropper.replaceAll(" ");

        Pattern punct = Pattern.compile("[,:-]");
        Matcher matcher = punct.matcher(s1);
        s1 = matcher.replaceAll(" ");

        Pattern space = Pattern.compile("[\\s]+");
        Matcher spacer = space.matcher(s1);
        s1 = spacer.replaceAll(" ");

        sentences = s1.split("[!.]");
        for (int i = 0; i < sentences.length; i++) {
            sentences[i].trim();
        }
        sortSentences(sentences);
        printSentences(sentences);

    }

    public static void sortSentences(String[] INeedToSort) {
        for (int i = 0; i < INeedToSort.length; i++) {
            for (int j = 0; j < INeedToSort.length - 1; j++) {
                String buff;
                if (INeedToSort[j].length() > INeedToSort[j + 1].length()) {
                    buff = INeedToSort[j];
                    INeedToSort[j] = INeedToSort[j + 1];
                    INeedToSort[j + 1] = buff;
                }
            }
        }
    }

    public static void printSentences(String[] arrayOfSentence) {
        for (int i = 0; i < arrayOfSentence.length; i++) {
            System.out.print(arrayOfSentence[i] + '\n');
        }
    }
}









