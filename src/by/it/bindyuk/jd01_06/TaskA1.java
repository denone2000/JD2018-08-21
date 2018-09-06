package by.it.bindyuk.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        System.out.println(Poem.text);
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = compile.matcher(sb);
        while (matcher.find()) {
            int position = matcher.start();
            sb.setCharAt(position + 3, '#');
            if (matcher.end() - matcher.start() >= 7)
                sb.setCharAt(position + 6, '#');
        }
        System.out.println(sb);
    }
}
