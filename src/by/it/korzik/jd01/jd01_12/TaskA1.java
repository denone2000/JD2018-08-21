package by.it.korzik.jd01.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private List<Integer> grades = new ArrayList<>();
    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            if (iterator.next()<4){
                iterator.remove();
            }
        }
        System.out.println(grades);
    }
    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        for (int i = 0; i <100 ; i++) {
           task.grades.add((int)(Math.random()*10)+1);
        }
        System.out.println(task.grades);
        task.clearBad(task.grades);
    }
}
