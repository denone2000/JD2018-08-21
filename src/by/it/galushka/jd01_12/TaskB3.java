package by.it.galushka.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;

public class TaskB3 {

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
