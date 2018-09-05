package by.it.bindyuk.jd01_06;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB11 {

    static private final String glas = "уеыаоэяиюёЁУЕЫАОЭЯИЮ";
    private static boolean checkWord(String word) {
    char firts = word.charAt(0);
    char last = word.charAt(word.length()-1);
        return glas.indexOf(firts)<0 && glas.indexOf(last)>=0;
    }

        public static void main(String[] args) {
            StringBuilder sb = new StringBuilder(Poem.text);
            Pattern compile = Pattern.compile("[а-яА-яёЁ]+");
            Matcher matcher = compile.matcher(sb);
            while (matcher.find()) {
                String word = matcher.group();
                if(checkWord(word))
                    System.out.println(word);
            }

        }
    }

