package by.it.kisielev.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskA2 {

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> result=new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        Set<Integer> result=new HashSet<>(a);
        result.retainAll(b);
        return result;
    }


    public static void main(String[] args) {
        Integer[] one={1,2,3,4,5,6,7,7,7,7};
        Integer[] two={4,5,6,7,8,9,9,9,9,4};

        List<Integer>oneList= Arrays.asList(one);
        List<Integer>twoList= Arrays.asList(two);

        Set<Integer> a= new HashSet<>(oneList);
        Set<Integer> b= new HashSet<>(twoList);

        Set<Integer> c= getUnion(a,b);
        System.out.println(c);

        Set<Integer> d=getCross(a, b);
        System.out.println(d);
    }
}
