package by.it.litvin.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    private static int numbers = 0;
    private static ArrayList<Double>list=new ArrayList<>();
    private static Scanner scanner;

    public static void main(String[] args) throws Exception{
        scanner=new Scanner(System.in);
            while (true){
                readData();
            }

    }

    static void readData()throws Exception{
        String words = scanner.nextLine();
        try {
            double num=Double.parseDouble(words);
            list.add(num);
        }catch (Exception e) {
            Thread.sleep(100);
            for (int i = list.size() - 1; i >= 0; i--) {
                System.out.print(list.get(i) + " ");

            }
        numbers++;
            if(numbers>4){
                throw new Exception();
            }
        }
    }


}
