package by.it.basumatarau.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        SetC<Short> set = new SetC<>();
        HashSet<Short> set2 = new HashSet<>();
        List<Short> added = new ArrayList<>();
        added.add(null);
        added.add(null);
        added.add((short) 1000);
        added.add((short) 1000);
        added.add((short) 1001);
        added.add((short) 1002);
        added.add(null);
        set.addAll(added);
        set2.addAll(added);

        System.out.println(set +" "+ set.size());
        System.out.println(set2 +" "+ set2.size());

        for(int i=0; i<10; i++){
            set.add((short)i);
            set2.add((short)i);
        }
        set.remove(null);
        set2.remove(null);
        Short shortOne = 1000;
        //set.remove(shortOne);
        //set2.remove(shortOne);

        System.out.println(set +" "+ set.size());
        System.out.println(set2 +" "+ set2.size());
        System.out.println(set.contains(null));
        System.out.println(set2.contains(null));
        System.out.println(set2.contains(-1));
        System.out.println(set.contains(-1));
    }
}
