package by.it.basumatarau.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListB<>();
        list.add(0,"test1");
        list.add(0, "test2");
        list.add(0, "test3");
        list.add(0, "test4");
        list.add("test5");
        System.out.println(list);

    }
}
