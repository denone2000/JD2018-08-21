package by.it.bindyuk.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;
        List<String> words = new ArrayList<>();
        while (!(word = scanner.next()).equals("end")) {
            scanner.useDelimiter("[^A-z'+]");
            words.add(word);
        }
        Set<String> UniqueWords = new HashSet<>(words);
        int buff = 0;
        Iterator<String> iterator = UniqueWords.iterator();


        while (iterator.hasNext()) {
            String search = iterator.next();
            for (int i = 0; i < words.size(); i++) {
                if (search.equals(words.get(i))) buff++;
            }
            System.out.println(search + "=" + buff);
            buff = 0;
        }
    }
}
