package by.it.korzik.jd01_13;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String line;
        double num;
        double sqrt;
        double sum=0;
        try {
            while (!(line=scan.next()).equalsIgnoreCase("end")) {
            num=Double.parseDouble(line);
            sum+=num;
            sqrt=Math.sqrt(sum);
                System.out.println(sqrt);
            }
        }
        catch (ArithmeticException | NumberFormatException e){
            String myTaskName = TaskB.class.getName();
            String name = e.getClass().getName();
            StackTraceElement[] stackTrace = e.getStackTrace();
            for (StackTraceElement element : stackTrace) {
                if (element.getClassName().equals(myTaskName)){
                    System.out.println(" name: "+name);
                    System.out.println("class: "+element.getClassName());
                    System.out.println(" line: "+element.getLineNumber());
                }
            }
        }
    }
}
