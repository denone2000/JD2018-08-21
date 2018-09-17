package by.it.galushka.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        String input;
        int pos = 0;
        while (!(input = scanner.next()).equals("end")) {
            Integer value = Integer.valueOf(input);
            if (value > 0) {
                list.add(pos, value);
                pos++;
            }
            else if (value == 0) {
                list.add(pos, value);
            }
            else {
                list.add(value);
            }
        }
        System.out.println(list);
    }
}
