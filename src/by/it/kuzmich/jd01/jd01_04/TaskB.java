package by.it.kuzmich.jd01.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numOfPeople = scan.nextInt();
        String[] secondName = new String[numOfPeople];
        for (int i = 0; i < numOfPeople; i++) {
            secondName[i] = scan.next();
        }
        int[][] salary = new int[numOfPeople][4];
        for (int i = 0; i < numOfPeople; i++) {
            System.out.println("Введите зарплату для " + secondName[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scan.nextInt();
            }
        }
        int[] all = new int[numOfPeople];
        for (int j = 0; j < numOfPeople ; j++) {
            for (int i = 0; i < 4; i++) {
                all [j] += salary [j][i];
            }
        }
                System.out.println("-------------------------------------------------------");
                System.out.printf("%-10s%-10s%-10s%-10s%-10s%s%n", "Фамилия ", "Квартал1 ", "Квартал2 ", "Квартал3 ", "Квартал4 ", "Итого");
                System.out.println("-------------------------------------------------------");
        for (int i = 0; i <numOfPeople ; i++) {
            System.out.printf("%8s:%-10d%-10d%-10d%-10d%-7d",secondName[i],salary[i][0],salary[i][1],salary[i][2],salary[i][3],all[i]);
            System.out.println();
        }
        System.out.println("-------------------------------------------------------");

        int sum = 0;
        for (int i : all) {
            sum +=i;
        }
        System.out.printf("%-7s%-10s","Итого: ",sum);
        double avg = (double) sum / (numOfPeople * 4);
        System.out.println();
        System.out.printf("%-7s%.5f","Средняя: ",avg);
    }
}