package by.it.galushka.demo.stringArray;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        String[] array = new String[3];
        List<String> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            array[i] = "String " + i + "\nword and word\n repeat word";
            list.add(array[i]);
        }
        System.out.println("Print array:\n");
        for (String s : array) {
            System.out.printf("%s", s);
        }
        System.out.println();
        System.out.println("Print list:\n");
        System.out.println(list);
    }
}
