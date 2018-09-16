package by.it.bindyuk.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<>();
        list.add("Uno");
        list.add("Double");
        list.add("Qattro");
        list.remove(0);
        System.out.println(list);
        System.out.println(list.get(0));
        List<Integer> listb = new ListB<>();
        listb.add(2);
        listb.add(4);
        listb.add(6);
        listb.add(8);
        listb.add(10);
        listb.add(12);
        listb.add(1,42);
        List<Integer> listc = new ListB<>();
        listc.add(1);
        listc.add(2);
        listc.add(3);
        listc.add(4);
        listb.addAll(listc);
        System.out.println(listb);


    }
}
