package by.it.basumatarau.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> wordMap = new HashMap<>(1024);
        Scanner scanner = new Scanner(System.in);
        String line;
        String[] words;
        while(!(line = scanner.nextLine()).equals("end")){
            words = line.split("([)\"]?\\s?[-—.,!?/;]?\\s+[(\"]?)|(\\s?[-/]\\s?)");
            outer:
            for (String word : words) {
                for(Map.Entry<String, Integer> entry: wordMap.entrySet()){
                    if(entry.getKey().equals(word)) {
                        entry.setValue(entry.getValue()+1);
                        continue outer;
                    }
                }
                wordMap.put(word, 1);
            }
        }
        System.out.println(wordMap);
    }
}
