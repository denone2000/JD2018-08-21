package by.it.basumatarau.jd01_12;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TaskA2 {
    Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> result = new HashSet<>(a);
        result.addAll(b);
        return result;
    }

    public static void main(String[] args) {

    }
}
