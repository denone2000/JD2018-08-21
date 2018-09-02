package by.it.basumatarau.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        String[] txt = Poem.text.split("\n");
        int max = txt[0].length();
        for (int i = 0; i < txt.length; i++) {
            if (max>txt[i].length()){
                max = txt[i].length();
            }
        }
        Pattern anyWord = Pattern.compile("");
        Matcher anyWordMatcher = anyWord.matcher("");
        for (int i = 0; i < txt.length; i++) {
            int delta = max-txt[i].length();
            anyWordMatcher.reset(txt[i]);
            int counter = 0;
            while(anyWordMatcher.matches()){
                counter++;
            }
            int addSpaces = txt[i].length()/counter;
            int addMoreSpaces = txt[i].length()%counter;

        }
    }

}
