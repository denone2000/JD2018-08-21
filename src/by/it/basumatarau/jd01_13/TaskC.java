package by.it.basumatarau.jd01_13;

import java.util.*;

public class TaskC {
    private static Deque<Double> dequeOfDoubles = new LinkedList<>();
    private static int excetionCounter = 0;
    private static Scanner scanner;

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        while(true){
            try {
                readData();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private static void readData() throws NumberFormatException, InterruptedException {
        try{
            dequeOfDoubles.push(Double.parseDouble(scanner.nextLine()));
        }catch (NumberFormatException e){
            if(excetionCounter++>=4){
                throw new NumberFormatException();
            }
            Thread.sleep(100);
            for (Double item : dequeOfDoubles) {
                System.out.printf("%s ", item);
            }
            System.out.print('\n');
        }
    }
}
