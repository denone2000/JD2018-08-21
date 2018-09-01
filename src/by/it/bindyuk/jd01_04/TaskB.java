package by.it.bindyuk.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество людей: ");
        int n = scanner.nextInt();
        String[] people = new String[n];
        System.out.println("Введите фамилии: ");
        for (int i = 0; i < people.length; i++) {
            people[i] = scanner.next();
            System.out.println(people[i]);
        }
        int[][] money = new int[n][4];
        for (int i = 0; i < money.length; i++) {
            System.out.println("Введите зарплату для " + people[i]);
            for (int j = 0; j < 4; j++) {
                money[i][j] = scanner.nextInt();
            }
        }
        int res = 0;
        for (int i = 0; i < money.length; i++) {
            for (int j = 0; j < money[0].length; j++) {
                res += money[i][j];
            }
        }

        System.out.println("--------------------------------------------------------");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println();
        System.out.println("--------------------------------------------------------");

        for (int i = 0; i < people.length; i++) {

            System.out.printf("%-9s%-10d%-10d%-10d%-10d%-5s", people[i] + ":", money[i][0], money[i][1], money[i][2],
                    money[i][3], (money[i][0] + money[i][1] + money[i][2] + money[i][3]));

            System.out.println();
        }
        System.out.println("--------------------------------------------------------");
        System.out.printf("%-9s%-10d", "Итого", res);
        System.out.println();
        double middleOfKvartal = (double) res / (n * 4);
        System.out.printf("%-9s%-10f", "Средняя", middleOfKvartal);

    }
}
