package by.it.galushka.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 9/1/2018.
 */
public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        sb.setCharAt(1, '#');
        Pattern compile = Pattern.compile("[а-яА-яёЁ]{4,}");
        Matcher matcher = compile.matcher(sb);
        while (matcher.find()) {
            int position = matcher.start();
            //System.out.println(matcher.group()+" "+position);
            sb.setCharAt(position+3, '#');
            if (matcher.end() - matcher.start() >= 7)
                sb.setCharAt(position+6, '#');
        }
        System.out.println(sb);
    }
}
