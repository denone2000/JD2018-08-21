package by.it.basumatarau.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private List<Integer> fielfGrades = new ArrayList<>();
    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while(iterator.hasNext()){
            if(iterator.next()<4) {
                iterator.remove();
            }
        }
    }
    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        for (int i = 0; i < 40; i++) {
            int grade = (int) Math.abs((Math.random()*10)-1);
            instance.fielfGrades.add(grade);
        }
        System.out.println(instance.fielfGrades);
    }
}
