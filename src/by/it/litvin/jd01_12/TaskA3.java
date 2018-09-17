package by.it.litvin.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String str;
        List<Integer> arr=new ArrayList<>();
        int pos=0;
        while (!(str=scanner.next()).equals("end")){
            int i = Integer.parseInt(str);
            if (i<0)
                arr.add(i);
            else if (i>0)
                arr.add(pos++,i);

            else
                arr.add(pos,i);
        }
        System.out.println(arr.toString());

    }
}
