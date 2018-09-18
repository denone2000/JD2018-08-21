package by.it.artemliashkov.jd01_12;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;
        ArrayList<String> arrayAllWord = new ArrayList<>();

        while (!(text = scanner.next()).equals("end")) {
            Pattern patternWord;
            patternWord = Pattern.compile("['a-zA-Zа-яА-Я]+");
            Matcher matcher = patternWord.matcher(text);
            while (matcher.find()) {
                String word = matcher.group();
                arrayAllWord.add(word);
            }
        }
        TreeMap<Integer, String> stringTreeMap = createTreeSetList(arrayAllWord);

        for (Map.Entry<Integer, String> element : stringTreeMap.entrySet()) {
            System.out.println(element.getValue());
        }
    }

    private static TreeMap<Integer, String> createTreeSetList(ArrayList<String> arrayAllWord) {
        TreeMap<Integer, String> stringTreeMap = new TreeMap<>();
        for (String element : arrayAllWord) {
            stringTreeMap.put(element.hashCode(), element);
        }
        return stringTreeMap;
    }
}
