package by.it.basumatarau.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder(Poem.text);
        Pattern regex = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = regex.matcher(sb);
        while(matcher.find()){
            int pos = matcher.start();
            sb.setCharAt(pos+3, '#');
            if(matcher.end() - matcher.start() > 6) sb.setCharAt(pos + 6, '#');
            System.out.println(matcher.group() + " " + pos);
        }
        System.out.println(sb);
    }
}


