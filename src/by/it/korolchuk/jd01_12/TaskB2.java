package by.it.korolchuk.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {

        ArrayList<String> peopleA = new ArrayList<>();
        LinkedList<String> peopleL = new LinkedList<>();

        Scanner sc = new Scanner(System.in);
        String names = sc.nextLine();

        Pattern patternWord = Pattern.compile("[A-Яа-яЁё]+");
        Matcher matcher = patternWord.matcher(names);
        while (matcher.find()) {
            String name = matcher.group();
            peopleA.add(name);
            peopleL.add(name);
        }

        System.out.println("Name" + ":" + process(peopleA));
        System.out.println("Name" + ":" + process(peopleL));
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


