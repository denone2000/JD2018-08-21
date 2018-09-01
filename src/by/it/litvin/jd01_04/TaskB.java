package by.it.litvin.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String fam[] = new String[n];
        for (int i = 0; i < fam.length; i++) {
            fam[i] = sc.next();

        }
        int zp[][] = new int[n][4];
        for (int i = 0; i < zp.length; i++) {
            System.out.println("Введите зарплату для " + fam[i]);
            for (int j = 0; j < 4; j++) { //
                zp[i][j] = sc.nextInt();

            }

        }
        System.out.println("-----------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-9s","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------------------------");
        int sumAll = 0;
        for (int i = 0; i < fam.length; i++) {
            System.out.printf("%-10s", fam[i]);
            //System.out.println();
            //System.out.println("-----------------------------------------------------------------------------------------");
            int sum = 0;
            for (int j = 0; j < zp[i].length; j++) {
                System.out.printf("%-10d", zp[i][j]);
                sum += zp[i][j];
            }
            System.out.printf(" %-11d\n",sum);

            sumAll+=sum;
        }
        System.out.printf("Итого=%d\nСредняя=%8.6f",sumAll,sumAll/4.0/n);


    }
}
