package by.it.artemliashkov.jd01_12;

import java.util.*;

public class TaskC2 {

    public static void main(String[] args) {
        Number[] one = {4.5, 2, 4, 5, 6};
        Number[] two = {2, 5, 6.5, 8, 8};
        Number[] three = {2, 5, 6.5, 9, 8};
        Number[] four = {2, 4, 6, 9, 8};

        List<Number> oneList = Arrays.asList(one);
        List<Number> twoList = Arrays.asList(two);
        List<Number> threeList = Arrays.asList(three);
        List<Number> fourList = Arrays.asList(four);

        Set<Number> a = new HashSet<>(oneList);
        Set<Number> b = new HashSet<>(twoList);
        Set<Number> c = new HashSet<>(threeList);
        Set<Number> d = new HashSet<>(fourList);

        Set<Number> resultGetUnion = getUnion(a, b, c, d);
        System.out.println(resultGetUnion);

        Set<Number> resultGetCross = getCross(a, b, c, d);
        System.out.println(resultGetCross);
    }

    private static Set<Number> getUnion(Collection<? extends Number>... sets) {
        Set<Number> result = new HashSet<>();
        for (Collection<? extends Number> elem : sets) {
            result.addAll(elem);
        }
        return result;
    }

    private static Set<Number> getCross(Collection<? extends Number>... sets) {
        Set<Number> result = new HashSet<>(sets[0]);
        for (Collection<? extends Number> elem : sets) {
            result.retainAll(elem);
        }
        return result;
    }
}
