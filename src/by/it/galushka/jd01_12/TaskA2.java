package by.it.galushka.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(1,2,3,4,4,5,5,6,6,7,8,9,9));
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1, 2, 3, 5, 5, 4, 7, 7, 7, 7, 6, 5, 4, 0));
        System.out.println(getUnion(hashSet, treeSet));
        System.out.println(getCross(hashSet, treeSet));
    }
}
