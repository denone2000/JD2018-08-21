package by.it.artemliashkov.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;


public class TaskB3 {

    public static void main(String[] args) {
        int n = 4096;
        ArrayList<String> peoplesArrayList = new ArrayList<>();
        LinkedList<String> peoplesLinkedList = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            peoplesArrayList.add("name" + i);
            peoplesLinkedList.add("name" + i);
        }
        long startPeoplesArrayList = System.nanoTime();//System.currentTimeMillis();
        process(peoplesArrayList);
        long endPeoplesArrayList = System.nanoTime();
        System.out.println("peoplesArrayList:" + peoplesArrayList + "        time:" + (endPeoplesArrayList - startPeoplesArrayList));

        long startPeoplesLinkedList = System.nanoTime();
        process(peoplesLinkedList);
        long endPeoplesLinkedList = System.nanoTime();
        System.out.println("peoplesLinkedList: " + peoplesLinkedList + "      time:" + (endPeoplesLinkedList - startPeoplesLinkedList));

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
            if (delete) {
                peoples.remove();
                delete = false;
            } else {
                peoples.add(peoples.poll());
                delete = true;
            }
        }
        return peoples.get(0);
    }
}
