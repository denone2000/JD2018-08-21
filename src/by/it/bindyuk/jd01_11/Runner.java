package by.it.bindyuk.jd01_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        SetC<String> test= new SetC<>();
        test.add("test");
        test.add("test1");
        test.add("test");
        test.add(null);

        System.out.println(test);


    }
}
