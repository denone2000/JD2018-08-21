package by.it.korolchuk.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String text;
        List<String> words = new ArrayList<>();

       while (!(text = sc.next()).equals("end")){
           Pattern patternWord = Pattern.compile("[A-Za-z'\\-]+");
           Matcher matcher = patternWord.matcher(text);
           while (matcher.find()) {
               String word = matcher.group();
               words.add(word);
           }
       }
        System.out.println(words);

        Set<String> uniqueWords = new HashSet<String>(words);
        for (String w : uniqueWords) {
            System.out.println(w + "=" + Collections.frequency(words, w));
        }
    }
}
