package by.it.litvin.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    static final String glas = "аеёиоуэюяыАЕЁИОУЭЮЯЫ";


    private static boolean сheckWord(String word) {
        char first = word.charAt(0);
        char last = word.charAt(word.length() - 1);
        return glas.indexOf(first) < 0 && glas.indexOf(last) >= 0;
    }

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[а-яА-яёЁ]+");
        Matcher matcher = compile.matcher(sb);
        while (matcher.find()) {
            String word = matcher.group();
            if (сheckWord(word))
            System.out.println(word);

        }
    }
}
