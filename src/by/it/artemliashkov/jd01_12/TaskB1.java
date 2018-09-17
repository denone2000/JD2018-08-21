package by.it.artemliashkov.jd01_12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String text;
        ArrayList<String> arrayAllword = new ArrayList<>();
        Map<String, Integer> words = new HashMap<>();
        while (!(text = scanner.next()).equals("end")) {
            Pattern patternWord = Pattern.compile("[a-zA-Z']+");
            Matcher matcher = patternWord.matcher(text);
            while (matcher.find()) {
                String word = matcher.group();
                arrayAllword.add(word);
            }
        }
        for (String element : arrayAllword) {
            if (words.size() == 0) {
                words.put(element, 1);
            } else if (words.containsKey(element)) {
                int count = words.get(element);
                words.replace(element, count, ++count);
            } else {
                words.put(element, 1);
            }
        }
        for (Map.Entry<String, Integer> entry : words.entrySet())
            System.out.println(entry.getKey() + "=" + entry.getValue());
    }
}
