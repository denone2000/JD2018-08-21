package by.it.nesterovich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static String[] sentence = {};

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        //StringBuilder space = new StringBuilder(" ");
        Pattern patternEllipsis = Pattern.compile("\\.{3}");
        Matcher matcher = patternEllipsis.matcher(Poem.text);
        String sb2 = matcher.replaceAll(" ");
        Pattern patternPunctuation = Pattern.compile("[:,-]");
        sb2 = patternPunctuation.matcher(sb2).replaceAll(" ");
        Pattern patternSpace = Pattern.compile("\\s+");
        sb2 = patternSpace.matcher(sb2).replaceAll(" ");
        Pattern patternSplit = Pattern.compile("[.!]");


        sentence = patternSplit.split(sb2);
        for (int i = 0; i < sentence.length; i++) {
            sentence[i] = sentence[i].trim();
        }

        System.out.println();
        sortStringArray(sentence);
        printArrayString(sentence);

    }

    private static void sortStringArray(String[] sentence) {
        for (int i = 0; i < sentence.length; i++) {
            for (int j = 0; j < sentence.length-1; j++) {
                if (sentence[j].length()>sentence[j+1].length()){
                    String temp = sentence[j];
                    sentence[j] = sentence[j+1];
                    sentence[j+1]=temp;
                }
            }
        }
    }


    public static void printArrayString(String[] array) {
        for (String element : array) {
            System.out.println(element);
        }
    }

}
