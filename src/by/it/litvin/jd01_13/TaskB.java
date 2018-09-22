package by.it.litvin.jd01_13;


import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str;
        double sum=0;
        double sqrt=0;
        double num;
        while (!(str=scan.next()).equals("END")){
            try {
                num=Double.parseDouble(str);
                sum+=num;
                sqrt=Math.sqrt(sum);
                if (sum<0){
                    throw new ArithmeticException();
                }
            }catch (Exception e){
                String myClassName=TaskB.class.getName();
                String name = e.getClass().getName();
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement element : stackTrace) {
                    if(element.getClassName().equals(myClassName)){
                        System.out.println("name: "+name);
                        System.out.println("class: "+element.getClassName());
                        System.out.println("line: "+element.getLineNumber());
                }
            }
                }
            System.out.println(sqrt);
            }

        }

    }

