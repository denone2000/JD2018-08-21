package by.it.korzik.jd01_12;

import by.it.basumatarau.jd01_05.TaskA;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskA2 {
    public static void main(String[] args) {
        Integer[] first = {1, 2, 3, 4, 4, 4, 4, 4, 4, 444, 5};
        Integer[] second = {1, 2, 3, 5555, 6, 7, 83, 6};

        List<Integer> listFirst = Arrays.asList(first);
        List<Integer> listSecond = Arrays.asList(second);

        Set<Integer> setFirst = new HashSet<>(listFirst);
        HashSet<Integer> setSecond = new HashSet<>(listSecond);

        TaskA2 task = new TaskA2();
        getUnion(setFirst, setSecond);
        getCross(setFirst,setSecond);
    }

    static Set<Integer> getUnion(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>(first);
        result.addAll(second);
        return result;
    }

    static Set<Integer> getCross(Set<Integer> first, Set<Integer> second) {
        Set<Integer> result = new HashSet<>(first);
        result.retainAll(second);
        return result;
    }
}