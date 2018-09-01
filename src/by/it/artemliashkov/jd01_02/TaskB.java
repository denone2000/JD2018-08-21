package by.it.artemliashkov.jd01_02;

import java.util.Scanner;


public class TaskB {
    public static void main(String args[])
    {
        Scanner scanner=new Scanner(System.in);
        double mas1,mas2,mas3;
        mas1=scanner.nextDouble();
        mas2=scanner.nextDouble();
        mas3=scanner.nextDouble();
        step3(mas1,mas2,mas3);
        int month;
        month=scanner.nextInt();
        step2(month);
        int mas[]=new int[25];
        for (int i = 0; i < mas.length; i++) {
            mas[i]=scanner.nextInt();
        }
        step1(mas);
    }

    public static void step1(int[] mas) {
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i]+" ");
            if(i % 5 == 4)
                System.out.println();
        }
    }

    public static void step2(int month) {
        switch (month)
        {
            case 1:{
                System.out.println("январь");
                break;
            }
            case 2:{
                System.out.println("февраль");
                break;
            }
            case 3:{
                System.out.println("март");
                break;
            }
            case 4:{
                System.out.println("апрель");
                break;
            }
            case 5:{
                System.out.println("май");
                break;
            }
            case 6:{
                System.out.println("июнь");
                break;
            }
            case 7:{
                System.out.println("июль");
                break;
            }
            case 8:{
                System.out.println("август");
                break;
            }
            case 9:{
                System.out.println("сентябрь");
                break;
            }
            case 10:{
                System.out.println("октябрь");
                break;
            }
            case 11:{
                System.out.println("ноябрь");
                break;
            }
            case 12:{
                System.out.println("декабрь");
                break;
            }
            default:{
                System.out.println("нет такого месяца");
            }
        }
    }

    public static void step3(double a, double b, double c) {
        double D=Math.pow(b,2)-4*(a*c);
        if(D>0)
        {
            double x1=(-b+Math.sqrt(D))/2*a;
            double x2=(-b-Math.sqrt(D))/2*a;
            System.out.println(x1 + " " +x2);
        }
        if(D==0)
        {
            double x1=-b/(2*a);
            System.out.println(x1 + " ");
        }
        else
            System.out.println("корней нет");
    }


}
