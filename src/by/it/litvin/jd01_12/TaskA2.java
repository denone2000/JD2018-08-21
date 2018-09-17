package by.it.litvin.jd01_12;

import java.util.*;

public class TaskA2 {

    private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two){
        Set<Integer> result= new HashSet<>(one);
        result.addAll(two);
        return result;
    }
    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two){
        Set<Integer> result= new HashSet<>(one);
        result.retainAll(two);
        return result;
    }
    public static void main(String[] args) {
//        TreeSet<Integer>treeSet=new TreeSet<>(Arrays.asList(1,2,3,4,5,6,6,6));
//        HashSet<Integer> hashSet=new HashSet<>(Arrays.asList(9,8,7,4,5,6,6,6));
//        System.out.println(getCross(treeSet,hashSet));
//        System.out.println(getUnion(treeSet,hashSet));

        Integer [] one = {1,2,3,4,4,4};
        Integer [] two = {1,2,3,4,5,6};

        List<Integer> oneList=Arrays.asList(one);
        List<Integer> twoList=Arrays.asList(two);

        Set<Integer>a=new HashSet<>(oneList);
        Set<Integer>b=new TreeSet<>(twoList);

        Set<Integer>c=getUnion(a,b);
        System.out.println(c);

        Set<Integer>d=getCross(a,b);
        System.out.println(d);

    }


}
