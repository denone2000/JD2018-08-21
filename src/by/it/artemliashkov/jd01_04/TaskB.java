package by.it.artemliashkov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String args[]) {
        Scanner scanner=new Scanner(System.in);
        Integer n=scanner.nextInt();
        int k[];
        String[] array=new String[n];
        int mas2[][]=new int[n][4];
        for (int i = 0; i < n; i++) {
            array[i]=scanner.next();
        }
        int sum[]=new int[n];
        for (int j = 0; j < n; j++)
        {
            System.out.println("Введите зарплату для: "+array[j]);
            for (int i = 0; i <4 ; i++) {
                mas2[j][i]=scanner.nextInt();
                System.out.print(mas2[j][i]+" ");
                sum[j]=sum[j]+mas2[j][i];
            }
            System.out.println();
        }
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-5s","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println();
        System.out.println("-------------------------------------------------------");
        for (int j = 0; j < n; j++) {
            System.out.printf("%-10s%-10d%-10d%-10d%-10d%-5d",array[j],mas2[j][0],mas2[j][1],mas2[j][2],mas2[j][3],sum[j]);
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");
        int all_sum=0;
        for (int i = 0; i < n; i++)
            all_sum=all_sum+sum[i];
        System.out.printf("%-10s%-10d","Итого",all_sum);
        System.out.println();
        System.out.printf("%-10s%-10.4f","Средняя",Double.parseDouble(String.valueOf(all_sum/(n*4.0))));//Не работает остаток от деления
    }
}
