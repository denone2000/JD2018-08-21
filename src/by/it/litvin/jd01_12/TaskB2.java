package by.it.litvin.jd01_12;

import java.util.*;

public class TaskB2 {
    static ArrayList<String> peoples = new ArrayList<>();
    static LinkedList<String> peoples2 = new LinkedList<>();

    static String process(ArrayList<String> peoples) {
        boolean remove = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (remove) {
                    iterator.remove();
                    remove = false;


                } else {
                    remove = true;
                }}}
                return peoples.get(0);}





    static String process(LinkedList<String> peoples2) {
        boolean remove=false;
        while (peoples2.size()>1){
            Iterator<String> iterator = peoples2.iterator();
            while (iterator.hasNext()){
                iterator.next();
               if (remove){
                   iterator.remove();
                   remove=false;
               }
               else{
                   remove=true;
               }


        }
    }
return peoples2.get(0);}

    public static void main(String[] args) {
        TaskB2 taskB2 = new TaskB2();
        taskB2.peoples.add("Олег");
        taskB2.peoples.add("Петя");
        taskB2.peoples.add("Женя");
        taskB2.peoples.add("Андрей");
        System.out.println(process((ArrayList<String>) taskB2.peoples));

        taskB2.peoples2.add("Олег");
        taskB2.peoples2.add("Петя");
        taskB2.peoples2.add("Женя");
        taskB2.peoples2.add("Андрей");
        System.out.println(process((LinkedList<String>) taskB2.peoples2));

    }
}
