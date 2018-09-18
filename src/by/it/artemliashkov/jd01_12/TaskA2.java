package by.it.artemliashkov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskA2 {

    static Set<Integer> getUnion(Set<Integer>a,Set<Integer>b)
    {
        Set <Integer>result=new HashSet<>();
        result.addAll(a);
        result.addAll(b);
        return result;
    }

    static Set<Integer> getCross(Set<Integer>a,Set<Integer>b)
    {
        Set <Integer>result=new HashSet<>();
        result.retainAll(a);
        result.retainAll(b);
        return result;
    }

    public static void main(String[] args)
    {
        Integer[] one={1,2,3,4,5,5,5};
        Integer[] two={4,5,6,6,6,6,7,8,9};
        List<Integer> oneList = Arrays.asList(one);
        List<Integer> twoList = Arrays.asList(one);
        Set<Integer> a=new HashSet<>(oneList);
        Set<Integer> b=new HashSet<>(twoList);
        System.out.println(a);
        Set<Integer> c = getCross(a, b);
        System.out.println(c);
    }
}
