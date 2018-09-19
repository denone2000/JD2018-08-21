package by.it.galushka.jd01_13;

import java.util.*;

public class TaskC {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner=new Scanner(System.in);
        readData(scanner);

    }

    static void readData(Scanner scanner) throws InterruptedException {
        List<Double> list = new LinkedList();
        boolean counter = false;
        for (int i = 0; i < 4; counter = true) {
            try {
                if (i == 4)
                    counter = false;
                while (counter == true) {
                    double num = scanner.nextDouble();
                    list.add(num);
                }
            } catch (Exception e) {
                Thread.sleep(100);
                int sizeList = list.size();
                for (int j = sizeList-1; j >= 0; j--) {
                    double res = list.get(j);
                    System.out.print(res + " ");
                }
                i++;
            }
        }


        //--------------------------------------
        //вывод в обратном порядке
//        int sizeList = list.size();
//        for (int i = sizeList-1; i >= 0; i--) {
//            double res = list.get(i);
//            System.out.print(res + " ");
//        }
        //--------------------------------------
    }
}
