package by.it.korzik.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String[] args) {
        int pos;
       StringBuilder sb = new StringBuilder(Poem.text);
        Pattern compile = Pattern.compile("[а-яА-яёЁ]{4,}");
        Matcher matcher = compile.matcher(sb);
        while(matcher.find()){
            pos=matcher.start();
            sb.setCharAt(pos+3,'#');
            if (matcher.end()-matcher.start()>=7){
                sb.setCharAt(pos+6,'#');
            }
        }
        System.out.println(sb);
    }
}
