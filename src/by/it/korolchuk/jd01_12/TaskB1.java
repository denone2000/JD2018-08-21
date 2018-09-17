package by.it.korolchuk.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word;

        List<String> words = new ArrayList<>();

       while (!(word = sc.next()).equals("end")){
           words.add(word.replace("[\\.:,;!?/—]", " "));
       }
        System.out.println(words);

        Set<String> uniqueWords = new HashSet<String>(words);
        for (String w : uniqueWords) {
            System.out.println(w + "=" + Collections.frequency(words, w));
        }
    }
}
