package by.it.basumatarau.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word;
        List<Integer> numList = new ArrayList<>();
        int positiveCoutner = 0;
        while (!(word=scanner.nextLine()).contains("end")){
            int num = Integer.parseInt(word);
            if (num>0){
                numList.add(positiveCoutner, num);
                positiveCoutner++;
            }else if (num<0){
                numList.add( numList.size(), num);
            }else{
                numList.add(positiveCoutner, num);
            }
        }
        System.out.println(numList);

    }
}
