package by.it.yaroshchuk.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        SetC<String> list = new SetC<>();
        list.add("ONE");
        list.add("TWO");
        list.add("THREE");
        list.add("THREE");
        System.out.println(list);

        //list.remove(0);
        //System.out.println(list);

    }
}
