package by.it.korolchuk.jd01_04;

import java.util.Arrays;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String empty = sc.nextLine();

        String[] surnames = new String[n];
        for (int i = 0; i < surnames.length; i++) {
            surnames[i] = sc.nextLine();
        }

        //тут начинается новый код
        int[][] salary = new int[n][4];


        System.out.println("Введите зарплату для Иванов");
        for (int i = 0; i < salary.length; i++) {
            if (i == 1) System.out.println("Введите зарплату для Петров");
            if (i == 2) System.out.println("Введите зарплату для Сидоров");
            String str = sc.nextLine();
            int[] inputData = Arrays.stream(str.split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j] = inputData[j];
                i = i++;

            }
        }
        //общая сумма
        int summ = 0;
        for (int i = 0; i < salary.length; i++) {
            for (int j = 0; j < salary[i].length; j++) {
                summ += salary[i][j];
            }
        }

        //сумма строк

        //1 строка


        int str1 = 0, str2 = 0, str3 = 0;
        for (int i = 0; i <= salary.length; i++) {
            str1 += salary[0][i];
        }

        //2 строка

        for (int i = 0; i <= salary.length; i++) {
            str2 += salary[1][i];
        }

        //3 строка
        for (int i = 0; i <= salary.length; i++) {
            str3 += salary[2][i];
        }

        //средняя зарплата

        double average = summ / ((double) salary.length * (double) salary[0].length);

        /*System.out.println(summ + " " + str1 + " " + str2 + " " + str3 + " " + average);*/


        System.out.printf("------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s%n", "Фамилия", "Квартал 1", "Квартал 2", "Квартал 3", "Квартал 4", "Итого");
        System.out.printf("------------------------------------------------------------------------------------------");
        System.out.println();

        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%-15s", surnames[i]);

            int sum = 0;
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-15d", salary[i][j]);
                sum += salary[i][j];
            }
            switch (i) {
                case (0) : System.out.printf("%-15d", str1);
                break;

                case (1) : System.out.printf("%-15d", str2);
                    break;

                case (2) : System.out.printf("%-15d", str3);
                    break;
            }


            System.out.println();
        }
        System.out.printf("------------------------------------------------------------------------------------------");
        System.out.println();
        System.out.printf("%-15s%-15d%n", "Итого", summ);
        System.out.printf("%-15s%-15.6f%n", "Средняя", average);


        }
    }


