package by.it.korzik.jd01.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<>();
        list.add("One");
        list.add("Two");
        list.remove(1);
        System.out.println(list.toString());
        List<String> listb = new ListB<>();
        listb.add("One");
        listb.add("Two");
        listb.add("Three");
        listb.add("Four");
        listb.remove(1);
        listb.set(1,"Five");
        System.out.println(listb.toString());
        ArrayList b = new ArrayList();
    }
}
