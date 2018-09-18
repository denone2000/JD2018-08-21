package by.it.nesterovich.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text;     //house's, and and the and passages of gold of end
        ArrayList<String> arrayAllWord = new ArrayList<>();

        while (!(text = scanner.next()).equals("end")) {
            Pattern patternWord = Pattern.compile("['a-zA-Zа-яА-Я]+");
            Matcher matcher = patternWord.matcher(text);
            while (matcher.find()) {
                String word = matcher.group();
                arrayAllWord.add(word);
            }
        }
        TreeMap<Integer, String> stringTreeMap = createTreeSetList(arrayAllWord);

        for (Map.Entry<Integer, String> element : stringTreeMap.entrySet()) {
            //System.out.print(element.getKey()+" ");
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
