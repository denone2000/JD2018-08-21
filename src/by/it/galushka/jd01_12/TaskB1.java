package by.it.galushka.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        StringBuilder text = getInputText();
        List<String> words = getWords(text);
        System.out.println(getHashMap(words));
    }

    private static HashMap getHashMap(List<String> words) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        Iterator<String> iterator = words.iterator();
        String word;
        while (iterator.hasNext()) {
            word = iterator.next();
            hashMap.put(word, 1);
        }
        for (Map.Entry<String, Integer> entry: hashMap.entrySet()){
            String key = entry.getKey();
            hashMap.replace(key, getRepeatCounter(words, key));
        }
        hashMap.remove("");
        return hashMap;
    }

    private static Integer getRepeatCounter(Iterable<String> words, String key) {
        Iterator<String> iterator = words.iterator();
        int counter = 0;
        while (iterator.hasNext()) {
            String word = iterator.next();
            if (word.equals(key))
                counter++;
        }
        return counter;
    }


    private static List getWords(StringBuilder text) {
        List<String> words = new ArrayList<>();
        Pattern pattern = Pattern.compile("[A-z']+");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String group = matcher.group();
            words.add(group);
        }
        return words;
    }

    private static StringBuilder getInputText() {
        StringBuilder result = new StringBuilder();
        Scanner scanner=new Scanner(System.in);
        String text;
        while (!(text = scanner.nextLine()).equals("end")) {
            result.append(" ").append(text.trim());
        }
        return result;
    }
}
