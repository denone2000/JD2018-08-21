package by.it.korzik.jd02_04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

 class PriorityMap {


    static int chooseoperation(List<String> operations) {
        Map<String, Integer> priorityMap = new HashMap<>();
        priorityMap.put("=", 0);
        priorityMap.put("+", 1);
        priorityMap.put("-", 1);
        priorityMap.put("*", 2);
        priorityMap.put("/", 2);
        int priority = -1;
        int index = -1;
        for (int i = 0; i < operations.size(); i++) {
            int currentPriority = priorityMap.get(operations.get(i));
            if (priority < currentPriority) {
                priority = currentPriority;
                index = i;
            }
        }
        return index;
    }
}
