package by.it.galushka.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 9/1/2018.
 */
public class TaskA2 {

    private static String[] words = {};
    private static int[] repeats = {};

    public static void main(String[] args) {
        StringBuilder sBuilder = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[А-Яа-яЁё]+");
        Matcher matcher = compile.matcher(sBuilder);
        while (matcher.find()) {
            String word = matcher.group();
            getArray(word);
        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d%n", words[i], repeats[i]);
        }
    }

    private static void getArray(String word) {
        for (int i = 0; i < words.length; i++) {
            if (word.equals(words[i])) {
                repeats[i]++;
                return;
            }
        }
        words = Arrays.copyOf(words, words.length+1);
        words[words.length-1] = word;
        repeats = Arrays.copyOf(repeats, repeats.length+1);
        repeats[repeats.length-1] = 1;
    }
}
