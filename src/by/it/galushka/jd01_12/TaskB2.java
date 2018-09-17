package by.it.galushka.jd01_12;

import java.util.*;

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
        boolean remove = false;
        while (peoples.size() > 1) {
            ListIterator<String> iterator = peoples.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (remove == true) {
                    iterator.remove();
                    remove = false;
                }
                else {
                    remove = true;
                }
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        boolean remove = false;
        while (peoples.size() > 1) {
            ListIterator<String> iterator = peoples.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (remove == true) {
                    iterator.remove();
                    remove = false;
                }
                else {
                    remove = true;
                }
            }
        }
        return peoples.get(0);
    }
}
