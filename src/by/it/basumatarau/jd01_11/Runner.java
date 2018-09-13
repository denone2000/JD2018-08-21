package by.it.basumatarau.jd01_11;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.add("test4");
        System.out.println(list);
        list.remove(1);
        System.out.println(list);
    }
}
