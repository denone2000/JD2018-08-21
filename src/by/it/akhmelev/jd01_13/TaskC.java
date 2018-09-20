package by.it.akhmelev.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    private static Scanner scanner;
    private static int counterError=0;
    private static List<Double> list = new ArrayList<Double>(){
        @Override
        public String toString() {
            StringBuilder sb=new StringBuilder();
            for (int i = this.size()-1; i >=0 ; i--) {
                sb.append(this.get(i)).append(' ');
            }
            return sb.toString();
        }
    };

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        while (true) {
            readData();
        }
    }

    private static void readData() {
        String str = scanner.next();
        try {
            double v = Double.parseDouble(str);
            list.add(v);
        } catch (NumberFormatException e) {
            try {
                if (++counterError>=5)
                    throw e;
                Thread.sleep(100);
                System.out.println(list);

            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
        }
    }
}
