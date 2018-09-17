package by.it.galushka.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
//      HashMap<String, Integer> hashMap = new HashMap<>();
        StringBuilder text = getInputText();
        List<String> words = getWords(text);
//        System.out.println(words);
//        System.out.println(words);
        System.out.println(countOfRepeat(words));
//        Scanner scanner=new Scanner(System.in);
//        String word;
//        while (!(word = scanner.nextLine()).equals("end")) {
//            int counter = 1;
//            for (Map.Entry<String, Integer> entry: hashMap.entrySet()) {
//                if (word.equals(entry.getKey())) {
//                    counter ++;
//                }
//            }
//            hashMap.put(word, counter);
//        }
//        hashMap.remove("");
//        System.out.println(hashMap);
    }

    private static HashMap countOfRepeat(List<String> words) {
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
//        for (Map.Entry<String, Integer> entry: hashMap.entrySet()) {
//            String key = entry.getKey();
//            int value = entry.getValue();
//            while (iterator.hasNext()) {
//                word = iterator.next();
//                if (key.equals(word)) {
//                    value++;
//                    hashMap.replace(word, value);
//                }
//            }
//        }
//                if (word.equals(entry.getKey())) {
//                    counter ++;
//                }
//            }
//            hashMap.put(word, counter);
//        }
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
            result.append(" " + text.trim());
        }
        return result;
    }
}
