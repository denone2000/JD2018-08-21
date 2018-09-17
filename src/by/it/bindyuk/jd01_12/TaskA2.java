package by.it.bindyuk.jd01_12;

import java.util.*;

public class TaskA2 {

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.retainAll(b);
        return result;
    }

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    public static void main(String[] args) {
        Integer[] one = {1, 2, 3, 1, 2, 3, 6, 7, 0, 7, 54, 3, 2, 15, 7};
        Integer[] two = {5, 6, 3, 1, 294, 6, 7, 0, 5, 54, 1, 2, 0, 7};
        List<Integer> listOne = Arrays.asList(one);
        List<Integer> listTwo = Arrays.asList(two);
        Set<Integer> a = new HashSet<>(listOne);
        Set<Integer> b = new HashSet<>(listTwo);

        System.out.println(getCross(a, b));
        System.out.println(getUnion(a, b));

        Integer[] one1 = {1, 2, 3, 1, 2, 3, 6, 7, 0, 7, 54, 3, 2, 15, 7};
        Integer[] two1 = {5, 6, 3, 1, 294, 6, 7, 0, 5, 54, 1, 2, 0, 7};
        List<Integer> listOne1 = Arrays.asList(one);
        List<Integer> listTwo1 = Arrays.asList(two);
        Set<Integer> a1 = new HashSet<>(listOne);
        Set<Integer> b1 = new TreeSet<>(listTwo);

        System.out.println(getCross(a1, b1));
        System.out.println(getUnion(a1, b1));

    }
}
