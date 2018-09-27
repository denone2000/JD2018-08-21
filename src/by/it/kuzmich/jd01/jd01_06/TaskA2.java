package by.it.kuzmich.jd01.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    private static String[] words = {};
    private static int[] count = {};


    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[а-яА-яёЁ]+");
        Matcher matcher = compile.matcher(sb);
        while (matcher.find()) {
            String word = matcher.group();
            int p = pos(word);
            if (p >= 0) {
                count[p]++;
            } else {
                int last = words.length;
                words = Arrays.copyOf(words, last + 1);
                words[last] = word;
                count = Arrays.copyOf(count, last + 1);
                count[last] = 1;

            }
        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n", words[i], count[i]);
        }
    }

    private static int pos(String word) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word)) {
                return i;
            }
        }
        return -1;
    }
}
