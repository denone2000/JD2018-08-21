package by.it.galushka.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        List<String> textArrayList = getText();
        getMap(textArrayList);
    }

    private static void getMap(List<String> list) {
        Map<Integer, String> C1 = new TreeMap<>();
        for (String value : list) {
            C1.put(getHash(value), value);
        }
        for (Map.Entry<Integer, String> treeMap : C1.entrySet()) {
            System.out.println(treeMap);
        }
    }

    private static int getHash(String word) {
        return word.hashCode();
    }

    private static List<String> getText() {
        List<String> list = new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        String input;
        while (!(input = scanner.nextLine()).equals("end")) {
            list.add(input.trim());
        }
        return list;
    }
}
