package by.it.basumatarau.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {

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
        boolean remove = false;
        while(people.size()>1){
            if (remove){
                people.pop();
                remove = false;
            }else{
                people.addLast(people.pop());
                remove = true;
            }
        }
        return people.getFirst();
    }

    static class Timer{
        long initTime;
        Timer(){
            initTime = System.nanoTime();
        }
        @Override
        public String toString(){
            long delta = System.nanoTime() - initTime;
            initTime = System.nanoTime();
            return delta/1000000+"ms elapsed";
        }
    }

    public static void main(String[] args) {
        ArrayList<String> listOne = new ArrayList<>();
        LinkedList<String> listTwo = new LinkedList<>();
        TaskB3.Timer timer = new Timer();

        for (int i = 0; i < 4096; i++) {
            listOne.add("val "+i);
            listTwo.add("val "+i);
        }
        System.out.println("warming up..." +timer);
        TaskB3.process(listOne);
        //ArrayList<> - type is slower when dealing with reallocation/resizing of the contained data structure (which is a rigid block of data)
        System.out.println("String process(ArrayList<String> people): " +timer);
        TaskB3.process(listTwo);
        System.out.println("String process(LinkedList<String> people): " +timer);

    }
}
