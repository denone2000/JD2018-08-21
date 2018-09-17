package by.it.basumatarau.jd01_12;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Map<Integer, String> sortedMap = new TreeMap<>();
        int pseudoHash = 0;
        while(!(line=scanner.nextLine().trim()).contains("end")){
            sortedMap.put(pseudoHash++,line.trim());
        }
        Map<Integer, String> sortedMapresult = new TreeMap<>();
        for (Map.Entry<Integer, String> entry : sortedMap.entrySet()) {
            sortedMapresult.put(entry.getValue().hashCode(), entry.getValue());
        }
        for (Map.Entry<Integer, String> entry : sortedMapresult.entrySet()) {
            System.out.printf("Item name: \"%s\", its hash#: %s\n", entry.getValue(), entry.getKey());
        }
    }
}
