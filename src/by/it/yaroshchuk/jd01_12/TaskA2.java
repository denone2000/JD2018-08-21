package by.it.yaroshchuk.jd01_12;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        HashSet<Integer> hashSet = new HashSet<>();

    }

    public static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two){
        Set<Integer> result = new HashSet<>(one);
        result.addAll(two);
        return result;
    }

    public static Set<Integer> getCross(Set<Integer> one, Set<Integer> two){
        Set<Integer> result = new HashSet<>(one);
        result.retainAll(two);
        return result;
    }
}
