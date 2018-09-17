package by.it.artemliashkov.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class TaskB2 {

    public static void main(String[] args) {
        int n = 10;
        ArrayList<String> peoplesArrayList = new ArrayList<>();
        LinkedList<String> peoplesLinkedList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            peoplesArrayList.add("name" + i);
            peoplesLinkedList.add("name" + i);
        }
        System.out.println("peoplesArrayList: " + process(peoplesArrayList));
        System.out.println("peoplesLinkedList: " + process(peoplesLinkedList));
    }

    private static String process(ArrayList<String> peoples) {
        boolean delete = false;
        while (peoples.size() > 1) {
            ListIterator<String> iterator = peoples.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (delete) {
                    iterator.remove();
                    delete = false;
                } else {
                    delete = true;
                }
            }
        }
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        boolean delete = false;
        while (peoples.size() > 1) {
            ListIterator<String> iterator = peoples.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (delete) {
                    iterator.remove();
                    delete = false;
                } else {
                    delete = true;
                }
            }
        }
        return peoples.get(0);
    }
}
