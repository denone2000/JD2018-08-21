package by.it.artemliashkov.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void  main(String[]args)
    {
        Scanner scanner=new Scanner(System.in);
        String word;
        List<Integer>list=new ArrayList<>();
        int zeroPos=0;

        while(!(word=scanner.next()).equals("end"))
        {
            int i=Integer.parseInt(word);
            if(i<0)
                list.add(i);
            else if(i>0)
                list.add(zeroPos++,i);
            else
                list.add(zeroPos,i);
        }
        System.out.println(list.toString());
    }
}
