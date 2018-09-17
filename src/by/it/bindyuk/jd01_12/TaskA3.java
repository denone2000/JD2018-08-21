package by.it.bindyuk.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        int positionPlus = 0;
        List<Integer> list = new ArrayList<>();
        while (!(str = scanner.next()).equals("end")) {
            int a = Integer.parseInt(str);
            if (a < 0) list.add(a);
            else if (a > 0) list.add(positionPlus++, a);
            else if (a==0) list.add(positionPlus,a);
        }
        System.out.println(list);
    }
}
