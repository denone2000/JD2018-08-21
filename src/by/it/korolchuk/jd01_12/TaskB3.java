package by.it.korolchuk.jd01_12;

import java.util.*;


public class TaskB3 {
    public static void main(String[] args) {

        ArrayList<String> peopleA = new ArrayList<>();
        LinkedList<String> peopleL = new LinkedList<>();

        int amount = 4096;
        for (int i = 0; i < amount; i++) {
            peopleA.add("name" + i);
            peopleL.add("name" + i);
        }
        long startPeopleA = System.nanoTime();
        process(peopleA);
        long endPeopleA = System.nanoTime();
        System.out.println(endPeopleA - startPeopleA);

        long startPeopleL = System.nanoTime();
        process(peopleL);
        long endPeopleL = System.nanoTime();
        System.out.println(endPeopleL - startPeopleL);
    }

    private static String process(ArrayList<String> peoples) {
        boolean remove = false;
        while (peoples.size() > 1) {
            ListIterator<String> iterator = peoples.listIterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (remove) {
                    iterator.remove();
                    remove = false;
                } else {
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
                if (remove) {
                    iterator.remove();
                    remove = false;
                } else {
                    remove = true;
                }
            }
        }
        return peoples.get(0);
    }
}


