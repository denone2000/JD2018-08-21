package by.it.nesterovich.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        System.out.println("Введите фамилии людей");
        String[] masivPeople = new String[n];
        for (int i = 0; i < masivPeople.length; i++) {
            masivPeople[i] = scanner.next();
        }

        int[][] salary = new int[n][4];
        for (int i = 0; i < masivPeople.length; i++) {
            System.out.println("Введите зартплату для " + masivPeople[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = scanner.nextInt();
            }
        }
        int totalAllPeoples = 0;
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < masivPeople.length; i++) {
            int totalPeople = 0;
            System.out.printf("%10s", masivPeople[i] + ":  ");
            for (int j = 0; j < salary[i].length; j++) {
                totalPeople = totalPeople + salary[i][j];

                System.out.printf("%-10d", salary[i][j]);
            }
            totalAllPeoples = totalAllPeoples + totalPeople;
            System.out.printf("%-10d%n", totalPeople);
        }
        double averageSalary = (double) totalAllPeoples / (n * 4);
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-10d%n", "Итого", totalAllPeoples);
        System.out.printf("%-10s%-10.4f", "Средняя", averageSalary);
    }
}
