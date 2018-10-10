package by.it.korzik.jd01.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int[] all = new int[num];
        String[] lastN = new String[num];
        int[][] sal = new int[num][4];
        for (int i = 0; i < num; i++) {
            lastN[i] = scan.next();
        }
        for (int i = 0; i < num; i++) {
            System.out.println("Введите зарплату для " + lastN[i]);
            for (int j = 0; j < 4; j++) {
                sal[i][j] = scan.nextInt();
            }
        }
        for (int j = 0; j < num; j++) {
            for (int i = 0; i < 4; i++) {
                all[j] += sal[j][i];
            }
        }
        System.out.println("------------------------------------------------------");
        System.out.printf("%7s%10s%10s%10s%10s%7s","Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println();
        System.out.println("------------------------------------------------------");
        for (int i = 0; i < num; i++) {
            System.out.printf("%7s: %-10d%-10d%-10d%-10d%-7d", lastN[i], sal[i][0], sal[i][1], sal[i][2], sal[i][3], all[i]);
            System.out.println();
        }
        int sum = 0;
        System.out.println("------------------------------------------------------");
        for (int i : all) {
            sum += i;
        }
        System.out.printf("%-7s%-10s", "Итого: ", sum);
        double avg = (double) sum / (num * 4);
        System.out.printf("%-7s%-10s", "Средняя ", avg);
    }
}
