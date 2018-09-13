package by.it.galushka.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListA<>();
        List<String> arList = new ArrayList<>();
        myList.add("ONE"); arList.add("ONE");
        myList.add("TWO"); arList.add("TWO");
        myList.add("THREE"); arList.add("THREE");
        System.out.println("myList: " + myList + "\n" + "arList: " + arList);
    }
}
