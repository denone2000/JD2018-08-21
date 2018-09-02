package by.it.galushka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[А-яЁё]+");
        Matcher matcher = compile.matcher(sb);
        while (matcher.find()) {
            String word = matcher.group();
            findWords(word);
        }
    }

    private static void findWords(String word) {
        char first = word.charAt(0);
        String start = String.valueOf(first);
        char last = word.charAt(word.length()-1);
        String end = String.valueOf(last);
        String[] vowels = {"а","е","ё","и","о","у","ы","э","ю","я"};
        boolean firstBool = true, lastBool = true;
        for (int i = 0; i < vowels.length; i++) {
            if (start.equalsIgnoreCase(vowels[i])) {
                firstBool = true;
                break;
            } else {
                firstBool = false;
            }
        }
        for (int i = 0; i < vowels.length; i++) {
            if (end.equalsIgnoreCase(vowels[i])) {
                lastBool = true;
                break;
            } else {
                lastBool = false;
            }
        }
        if (firstBool == false && lastBool == true ) {
                System.out.println(word);
        }
    }
}
