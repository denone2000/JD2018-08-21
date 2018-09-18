package by.it.nesterovich.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {

    public static void main(String[] args) {

        //проверка класса ListB
        List<String> myList = new ListB<>();
        List<String> arList = new ArrayList<>();
        //проверка метода add
        String string1 = "1";
        String string2 = "2";
        String string3 = "3";
        myList.add(string1); arList.add(string1);
        myList.add(string2); arList.add(string2);
        myList.add(string3); arList.add(string3);
        System.out.println("myList.add:"+myList);
        System.out.println("arList.add:"+arList);
        //проверка метода remove
        myList.remove(0); arList.remove(0);
        System.out.println("myList.remove:"+myList);
        System.out.println("arList.remove:"+arList);
        //проверка метода get
        myList.get(0); arList.get(0);
        System.out.println("myList.get:"+myList);
        System.out.println("arList.get:"+arList);
        //проверка метода set
        myList.set(1,"4"); arList.set(1,"4");
        System.out.println("myList.set:"+myList);
        System.out.println("arList.set:"+arList);
        //проверка метода add(int index, T e)
        myList.add(0,"9"); arList.add(0,"9");
        System.out.println("myList.add:"+myList);
        System.out.println("arList.add:"+arList);
        //проверка метода addAll(List<?> c)
        myList.addAll(myList);  arList.addAll(arList);
        System.out.println("myList.addAll:"+myList);
        System.out.println("arList.addAll:"+arList);


        //проверка класса SetC
        Set<String> mySet = new SetC<>();
        HashSet<String> haSet = new HashSet<>();
        //проверка метода add
        mySet.add("1"); haSet.add("1");
        mySet.add("t"); haSet.add("t");
        mySet.add("3"); haSet.add("3");
        System.out.println("mySet.add:"+mySet);
        System.out.println("haSet.add:"+haSet);


    }
}
