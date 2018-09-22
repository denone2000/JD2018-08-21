package by.it.artemliashkov.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        String line;
        Double sum=0.0;
        while (!(line = scanner.next()).equals("END"))
        {
            try{
                System.out.println(Double.parseDouble(line));
                if(Double.isNaN(Math.sqrt(Double.parseDouble(line))+sum)){
                    throw new ArithmeticException();
                }
                sum=sum+Double.parseDouble(line);
                System.out.println(Math.sqrt(sum));
            }catch (Exception e){
                String myClassName = TaskB.class.getName();
                String name=e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for(StackTraceElement element:stackTrace)
                {
                    if(element.getClassName().equals(myClassName))
                    {
                        System.out.println("name: "+name);
                        System.out.println("class: "+element.getClassName());
                        System.out.println("line: "+element.getLineNumber());
                    }

                }
            }
        }
    }
}
