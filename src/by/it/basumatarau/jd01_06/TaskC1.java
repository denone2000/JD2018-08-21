package by.it.basumatarau.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        StringBuilder text = new StringBuilder(Poem.text);
        String[] txt = Poem.text.split("\n");
        int max = txt[0].length();
        for (int i = 0; i < txt.length; i++) {
            if (max<txt[i].length()){
                max = txt[i].length();
            }
        }
        Pattern anyWord = Pattern.compile("[а-яА-ЯёЁ,.:-]+");
        Matcher anyWordMatcher = anyWord.matcher("");
        StringBuilder formattedText = new StringBuilder();
        for (int i = 0; i < txt.length; i++) {
            int delta = max-txt[i].length();

            anyWordMatcher.reset(txt[i]);
            int counter = 0;
            while(anyWordMatcher.find()){
                counter++;
            }
            int addSpaces = delta/(counter-1);
            StringBuilder wordIndentRight = new StringBuilder();
            for (int j = 0; j < addSpaces; j++) {
                wordIndentRight.append(" ");
            }
            int addMoreSpaces = delta%(counter-1);
            StringBuilder formattedString = new StringBuilder(txt[i]);
            anyWordMatcher.reset(txt[i]);
            int aux = 0;

            for(int j=0; j < counter-1 && anyWordMatcher.find(); j++){
                int pos = anyWordMatcher.end();
                formattedString.insert(pos + aux +j*addSpaces, wordIndentRight);
                if(addMoreSpaces-->0){
                    formattedString.insert(pos+ aux++ + j*addSpaces, " ");
                }
            }

            txt[i] = new String(formattedString);
        }
        for (int i = 0; i < txt.length; i++) {
            System.out.println(txt[i]);
        }
    }

}
