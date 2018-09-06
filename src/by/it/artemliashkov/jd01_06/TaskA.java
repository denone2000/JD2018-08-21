package by.it.artemliashkov.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    public static void main(String args[])
    {
        StringBuilder sb=new StringBuilder(Poem.text);
        Pattern compile=Pattern.compile("[a-яА-ЯёЁ]{4,}");
        Matcher mathcer=compile.matcher(sb);
        while(mathcer.find())
        {
            Integer position=mathcer.start();
            sb.setCharAt(position+3,'#');
            if(mathcer.end()-mathcer.start()>=7)
                sb.setCharAt(position+3,'#');
        }
        System.out.println(sb);

    }
}
