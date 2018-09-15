package by.it.basumatarau.jd01_12;

import java.util.*;

public class TaskA2 {
    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }
    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }
    public static void main(String[] args) {
        Set<Integer> someIntSet = new HashSet<>(Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6}));
        Set<Integer> someOtherIntSet = new HashSet<>(Arrays.asList(new Integer[]{4, 5, 6, 7, 8, 9}));
        System.out.println(TaskA2.getCross(someIntSet, someOtherIntSet));
        System.out.println(TaskA2.getUnion(someIntSet, someOtherIntSet));
    }
}
