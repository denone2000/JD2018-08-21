package by.it.bindyuk.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] words = {};
    private static int[] counts = {};

    private static void process(String word) {
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                counts[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length + 1);
        words[words.length - 1] = word;
        counts = Arrays.copyOf(counts, counts.length + 1);
        counts[counts.length - 1] = 1;

    }

    private static void printWords() {
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n", words[i], counts[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[а-яА-яёЁ]+");
        Matcher matcher = compile.matcher(sb);
        while (matcher.find()) {
            String word = matcher.group();
            process(word);
        }
        printWords();
    }
}
