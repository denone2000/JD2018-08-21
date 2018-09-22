package by.it.artemliashkov.jd01_13;


import java.util.*;

public class TaskC {
    private static LinkedList<Double> setDoubles = new LinkedList<>();
    private static int counter = 0;
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
            setDoubles.push(Double.parseDouble(scanner.nextLine()));
        }catch (NumberFormatException e){
            counter++;
            if(counter>=5){
                throw new NumberFormatException();
            }
            Thread.sleep(100);
            for (Double item : setDoubles) {
                System.out.printf("%s ", item);
            }
            System.out.print('\n');
        }
    }
}