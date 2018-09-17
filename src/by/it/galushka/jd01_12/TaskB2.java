package by.it.galushka.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB2 {

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        arrayList.add("Вася");arrayList.add("Петя");arrayList.add("Гриша");arrayList.add("Саша");arrayList.add("Костя");
        linkedList.add("Вася");linkedList.add("Петя");linkedList.add("Гриша");linkedList.add("Саша");linkedList.add("Костя");
        System.out.println(process(arrayList));
        System.out.println(process(linkedList));

    }

    static String process(ArrayList<String> peoples) {
        ArrayList<String> removeNames = new ArrayList<>();
        int counter = 1;
        if (peoples.size() <= 1) {
            return peoples.toString();
        }
        else {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                String name = iterator.next();
                if (counter % 2 != 0) {
                    removeNames.add(name);
                    counter++;
                }
                else
                    counter++;
            }
        }
        return process(removeNames);
    }

    static String process(LinkedList<String> peoples) {

        return null;
    }
}
