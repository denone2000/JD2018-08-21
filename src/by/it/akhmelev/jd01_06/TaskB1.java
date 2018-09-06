package by.it.akhmelev.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class TaskB1 {

    static final String glas="уеэоаыяиюУЕЭОАЫЯИЮёЁ";

    private static boolean checkWord(String word) {
        char first=word.charAt(0);
        char last=word.charAt(word.length()-1);
        return glas.indexOf(first)<0 && glas.indexOf(last)>=0;
    }


    public static void main(String[] args) {
        Pattern compile = Pattern.compile("[а-яА-яёЁ]+");
        Matcher matcher = compile.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            if (checkWord(word))
                System.out.println(word);
            ;
        }
    }


}
