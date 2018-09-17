package by.it.galushka.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {

    private List<Integer> marks = new ArrayList<>();

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        for (int i = 0; i < 20; i++) {
            task.marks.add((int)((Math.random()*10)+1));
        }
        System.out.println(task.marks);
        task.clearBad(task.marks);
        System.out.println(task.marks);
    }

    private void clearBad(List<Integer> grades) {
        for (Iterator<Integer> iterator = grades.iterator(); iterator.hasNext();) {
            int grade = iterator.next();
            if (grade < 4) {
                iterator.remove();
            }
        }

    }
}
