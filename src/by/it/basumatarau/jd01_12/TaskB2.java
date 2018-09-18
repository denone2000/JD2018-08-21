package by.it.basumatarau.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    static String process(ArrayList<String> people){
        Iterator<String> iterator = people.iterator();
        boolean deletion = false;
        while (people.size()>1){
            while(iterator.hasNext()) {
                if (deletion) {
                    iterator.next();
                    iterator.remove();
                    deletion=false;
                }else {
                    iterator.next();
                    deletion = true;
                }
            }
            iterator = people.iterator();
        }
        return people.get(0);
    }

    static String process(LinkedList<String> people){
        Iterator<String> iterator = people.iterator();
        boolean deletion = false;
        while (people.size()>1){
            while(iterator.hasNext()) {
                if (deletion) {
                    iterator.next();
                    iterator.remove();
                    deletion=false;
                }else {
                    iterator.next();
                    deletion = true;
                }
            }
            iterator = people.iterator();
        }
        return people.getFirst();
    }

    public static void main(String[] args) {
        ArrayList<String> listOne = new ArrayList<>();
        LinkedList<String> listTwo = new LinkedList<>();

        for (int i = 1; i < 3; i++) {
            listOne.add("val "+i);
            listTwo.add("val "+i);
        }
        System.out.println("before listOne: "+listOne);
        System.out.println("before listTwo: "+listTwo);

        TaskB2.process(listOne);
        TaskB2.process(listTwo);
        System.out.println("after listOne: "+listOne);
        System.out.println("after listTwo: "+listTwo);
    }
}
