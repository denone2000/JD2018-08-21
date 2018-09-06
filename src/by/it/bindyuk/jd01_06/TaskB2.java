package by.it.bindyuk.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {

    private static String[] sentences = {};

    public static void main(String[] args) {
        StringBuilder sb2 = new StringBuilder(Poem.text);
        Pattern pattern2 = Pattern.compile("[:,-]");
        Matcher matcher2 = pattern2.matcher(sb2);
        String sb3 = matcher2.replaceAll("");

        StringBuilder sb4 = new StringBuilder(sb3);

        Pattern pattern3 = Pattern.compile("[\\.\\.\\.]+[.]");
        Matcher matcher3 = pattern3.matcher(sb4);
        String sb5 = matcher3.replaceAll("");

        StringBuilder sb6 = new StringBuilder(sb5);

        Pattern pattern4 = Pattern.compile("[^.!]+");
        Matcher matcher4 = pattern4.matcher(sb6);
        while (matcher4.find()) {
            String sentence = matcher4.group();
            sentence.trim();
            processSort(sentence);
        }
        sort1(sentences);
        for (int i = 0; i <sentences.length ; i++) {
            System.out.println(sentences[i]);
        }

    }


    private static String[] processSort(String sentence) {
        sentences = Arrays.copyOf(sentences, sentences.length + 1);
        sentences[sentences.length - 1] = sentence;
        return sentences;
    }

    private static void sort1(String[] sentences) {
        boolean swap;
        int last = sentences.length-1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                String buff;
                if (sentences[i].length() > sentences[i + 1].length()) {
                    buff = sentences[i];
                    sentences[i] = sentences[i + 1];
                    sentences[i + 1] = buff;
                    swap = true;
                }
            }
            last--;
        } while (swap);

    }

}







