package by.it.galushka.demo.testPriorityMethod;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Run {

    private static Map<Integer, String> putPriority() {
        Map<Integer, String> priority = new HashMap<>();
        priority.put(0, "=");
        priority.put(1, "+");
        priority.put(2, "-");
        priority.put(3, "*");
        priority.put(4, "/");
        return priority;
    }

    public static void main(String[] args) {
        putPriority();
        List<String> operations = new ArrayList<>();
        List<String> result = new ArrayList<>();
        operations.add("=");
        operations.add("*");
        operations.add("+");
        operations.add("/");
        operations.add("-");
        System.out.println(operations);
        while (operations.size() > 0) {
            int indexHighPriority = priorityForCalc(operations);
            result.add(operations.remove(indexHighPriority));
        }
        System.out.println(result);
    }

    private static int priorityForCalc(List<String> operations) {
        Map<Integer, String> priority = putPriority();
        int higherPriorityIndex = -1;
        int indexHighPriorValue = -1;
        for (Map.Entry<Integer, String> entry : priority.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            for (int j = 0; j < operations.size(); j++) {
                int actualPrioroty = -1;
                if (value.equals(operations.get(j))) {
                    actualPrioroty = key;
                    if (actualPrioroty > higherPriorityIndex) {
                        higherPriorityIndex = actualPrioroty;
                        indexHighPriorValue = j;
                    }
                }
            }
        }
        return indexHighPriorValue;
    }
}
