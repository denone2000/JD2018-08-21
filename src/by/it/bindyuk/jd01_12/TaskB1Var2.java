package by.it.bindyuk.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1Var2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String lines;
        Map<String, Integer> map = new HashMap<>();
        while (true) {
            lines = scanner.nextLine();
            if (lines.equals("end"))
                break;

            String[] words = lines.split("[^a-zA-Z']+");

            for (String word : words) {
                if (map.containsKey(word)) {
                    int count = map.get(word);
                    map.put(word, count++);
                } else map.put(word, 1);
            }
        }
        for (Map.Entry<String, Integer> entries : map.entrySet()) {
            System.out.println(entries.getKey() + "=" + entries.getValue());
        }
    }
}



