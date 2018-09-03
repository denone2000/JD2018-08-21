package by.it.artemliashkov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA1 {
    public static void main(String args[])
    {
        StringBuilder sb=new StringBuilder(Poem.text);
        Pattern compile=Pattern.compile("[a-яА-ЯёЁ]{4,}");
        Matcher mathcer=compile.matcher(Poem.text);
        while(mathcer.find())
        {
            int start=mathcer.start();
            sb.setCharAt(start+3,'#');
            if(mathcer.group().length()>=7)
                sb.setCharAt(start+6,'#');
        }
        System.out.println(sb);

    }
}
