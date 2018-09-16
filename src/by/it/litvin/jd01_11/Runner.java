package by.it.litvin.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String>list=new ListA<>();
        list.add("One");
        list.add("two");
        list.add("three");
        System.out.println(list);
        list.remove(2);
        System.out.println(list);
        System.out.println(list.get(1));
        List<Integer>list1=new ListB<>();
        list1.add(1);
        list1.add(5);
        list1.add(4);
        list1.add(3);
        list1.add(2);
        System.out.println(list1);
        list1.add(1,2);
        System.out.println(list1);
        List<Integer>list2=new ListB<>();
        list2.add(6);
        list2.add(7);
        list2.add(8);
        System.out.println(list2);
        //list1.addAll(list2);
        //System.out.println(list1);

    }
}
