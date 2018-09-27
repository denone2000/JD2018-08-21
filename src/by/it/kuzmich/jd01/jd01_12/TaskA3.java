package by.it.kuzmich.jd01.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;
        List<Integer> list = new ArrayList<>();
        int zeroPosition = 0;
        while (!(word = scanner.next()).equals("end")) {
            int num = Integer.parseInt(word);
            if (num < 0)
                list.add(num);
            else if (num > 0) {
                list.add(zeroPosition++, num);
            } else
                list.add(zeroPosition, num);
        }
        System.out.println(list.toString());

    }
}
