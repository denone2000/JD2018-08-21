package by.it.korolchuk.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private List<Integer> fieldGrades = new ArrayList<>();

    void clearBad ( List <Integer> grades) {

        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            Integer value = iterator.next();
            if (value < 4) {
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();

        for (int i = 0; i < 40; i++) {
            int grade = (int) (Math.random() * 10) + 1;
            instance.fieldGrades.add(grade);
        }
        System.out.println(instance.fieldGrades);
        instance.clearBad(instance.fieldGrades);
    }



}
