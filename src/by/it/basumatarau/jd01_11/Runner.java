package by.it.basumatarau.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ListA<String>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        System.out.println(list);
        list.remove(0);
        System.out.println(list);

    }
}
