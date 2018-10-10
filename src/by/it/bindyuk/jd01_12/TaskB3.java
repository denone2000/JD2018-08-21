package by.it.bindyuk.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class TaskB3<E> {


    List<String> peoples = new ArrayList<>();
    List<String> peoples2 = new LinkedList<>();
    static int buff = 0;
    static int buff2 = 0;

    static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        if (peoples.size() == 1) {
            buff = 0;
            return peoples.get(0);
        }
        if (buff == 0) {
            while (iterator.hasNext()) {
                iterator.next();
                buff = 1;
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                    buff = 0;
                }
            }
            if (peoples.size() != 1) {
                process(peoples);
            }
            if (peoples.size() == 1) {
                buff = 0;
                return peoples.get(0);
            }

        } else if (buff == 1) {
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
                buff = 0;
                if (iterator.hasNext()) {
                    iterator.next();
                    buff = 1;
                }
            }
            if (peoples.size() != 1) {
                process(peoples);
            }
            if (peoples.size() == 1) {
                buff = 0;
                return peoples.get(0);
            }
        }
        buff = 0;
        return peoples.get(0);

    }


    static String process(LinkedList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        if (peoples.size() == 1) {
            buff2 = 0;
            return peoples.get(0);
        }
        if (buff2 == 0) {
            while (iterator.hasNext()) {
                iterator.next();
                buff2 = 1;
                if (iterator.hasNext()) {
                    iterator.next();
                    iterator.remove();
                    buff2 = 0;
                }
            }
            if (peoples.size() != 1) {
                process(peoples);
            }
            if (peoples.size() == 1) {
                buff2 = 0;
                return peoples.get(0);
            }


        } else if (buff2 == 1) {
            while (iterator.hasNext()) {
                iterator.next();
                iterator.remove();
                buff2 = 0;
                if (iterator.hasNext()) {
                    iterator.next();
                    buff2 = 1;
                }
            }
            if (peoples.size() != 1) {
                process(peoples);
            }

        }
        buff2 = 0;
        return peoples.get(0);
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
        TaskB3 tester = new TaskB3();
        Timer t = new Timer();
        for (int i = 0; i < 4096; i++) {
            tester.peoples2.add("test");
        }
        for (int i = 0; i < 4096; i++) {
            tester.peoples.add("test");
        }
        process((ArrayList<String>)tester.peoples);
        System.out.println(t);


        process((LinkedList<String>) tester.peoples2);
        System.out.println(t);
    }

}


