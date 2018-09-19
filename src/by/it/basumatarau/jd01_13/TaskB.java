package by.it.basumatarau.jd01_13;

import java.io.IOException;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Double sum=0.0;
        while(!(line=scanner.nextLine()).toLowerCase().contains("end")){
            try{
                System.out.println(Double.parseDouble(line));
                if(Double.isNaN(Math.sqrt(Double.parseDouble(line))+sum)){
                    throw new ArithmeticException();
                }
                sum+=Double.parseDouble(line);
                System.out.println(Math.sqrt(sum));
            }catch (NumberFormatException | ArithmeticException e){
                for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                    if(stackTraceElement.getClassName().equals(TaskB.class.getName())){
                        System.out.println(" name: "+e);
                        System.out.println("class: "+TaskB.class.getName());
                        System.out.println(" line: "+ stackTraceElement.getLineNumber());
                    }
                }
            }

        }
    }
}
