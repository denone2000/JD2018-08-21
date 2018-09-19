package by.it.litvin.jd01_12;


import by.it.litvin.jd01_04.TaskA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
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
                }
            }
        }
        return peoples.get(0);
    }


    static String process(LinkedList<String> peoples2) {
        boolean remove = false;
        while (peoples2.size() > 1) {
            Iterator<String> iterator = peoples2.iterator();
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
        return peoples2.get(0);
    }

    public static class Timer {
        public long iniTime;
        private Double Delta;

        public Timer() {
            iniTime = System.nanoTime();
        }

        public String toString() {
            Delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();
            return "Прошло" + Delta.toString() + "микросекунд";
        }
    }


    public static void main(String[] args) {
        TaskB3 taskB3 = new TaskB3();
        Timer timer = new Timer();
        for (int i = 0; i <4096 ; i++) {
            taskB3.peoples.add("check");
        }
            for (int i = 0; i <4096 ; i++) {
            taskB3.peoples2.add("check");


        }
        process((ArrayList<String>)taskB3.peoples);
        System.out.println(timer);
        process((LinkedList<String>)taskB3.peoples2);
        System.out.println(timer);


    }


}



