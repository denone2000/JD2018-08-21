package by.it.artemliashkov.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String args[])
    {
        List<String> list=new ArrayList<>();
        list.add("ONE");
        list.add("TWO");
        list.add("THREE");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.get(1);
        System.out.println(list);
    }
}
