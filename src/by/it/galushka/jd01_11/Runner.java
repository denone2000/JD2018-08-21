package by.it.galushka.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {

        //Runner ListA
        List<String> myList = new ListA<>();
        List<String> arList = new ArrayList<>();
        myList.add("ONE"); arList.add("ONE");
        myList.add("TWO"); arList.add("TWO");
        myList.add("THREE"); arList.add("THREE");
        System.out.println("myList: " + myList + "\n" + "arList: " + arList);
        myList.add(2, "FOUR (added by index)");
        arList.add(2, "FOUR (added by index)");
        System.out.println("myList after add by index: " + myList +
                "\n" + "arList after add by index: " + arList);
        myList.remove("FOUR (added by index)");
        arList.remove("FOUR (added by index)");
        System.out.println("myList after remove by \"o\": " + myList +
                "\n" + "arList after remove by \"o\": " + arList);
        myList.remove(2);
        arList.remove(2);
        System.out.println("myList after remove by index: " + myList +
                "\n" + "arList after remove by index: " + arList);
        System.out.println("myList get(index 1): " + myList.get(1) +
                        "\n" + "arList get(index 1): " + arList.get(1));

        //Runner ListB
        List<String> myListB = new ListB<>();
        List<String> arListB = new ArrayList<>();
        List<String> arEmptyList = new ArrayList<>();
        myListB.add("one"); arListB.add("one");
        myListB.add("two"); arListB.add("two");
        myListB.add("three"); arListB.add("three");
        System.out.println("myListB: " + myListB +
                "\n" + "arListB: " + arListB);
        myListB.set(2, "four(set by index)");
        arListB.set(2, "four(set by index)");
        System.out.println("myListB set by index: " + myListB +
                "\n" + "arListB set by index: " + arListB);
        myListB.add(2, "four(added by index)");
        arListB.add(2, "four(added by index)");
        System.out.println("myListB add by index: " + myListB +
                "\n" + "arListB add by index: " + arListB);
        System.out.println("arEmptyList before addAll: " + arEmptyList);
        arEmptyList.addAll(arListB);
        System.out.println("arEmptyList after addAll: " + arEmptyList);
    }
}
