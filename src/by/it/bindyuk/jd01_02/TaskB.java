package by.it.bindyuk.jd01_02;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        step1();
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите номер месяца: ");
        int month = sc.nextInt();
        step2(month);
        System.out.println("Введите аругменты: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        step3(a, b, c);
    }

    static void step1() {
        int[][] matrix = new int[5][5];
        int buff = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = ++buff;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void step2(int month) {

        switch (month) {
            case 1:
                System.out.println("январь");
                break;
            case 2:
                System.out.println("февраль");
                break;
            case 3:
                System.out.println("март");
                break;
            case 4:
                System.out.println("апрель");
                break;
            case 5:
                System.out.println("май");
                break;
            case 6:
                System.out.println("июнь");
                break;
            case 7:
                System.out.println("июль");
                break;
            case 8:
                System.out.println("август");
                break;
            case 9:
                System.out.println("сентябрь");
                break;
            case 10:
                System.out.println("октябрь");
                break;
            case 11:
                System.out.println("ноябрь");
                break;
            case 12:
                System.out.println("декабрь");
                break;
            default:
                System.out.println("нет такого месяца");
        }
    }

    static void step3(double a, double b, double c) {
                double x1, x2;
                double discriminant = (b * b) - 4 * a * c;
                double sqrtDiscriminant = Math.sqrt(discriminant);
                if (discriminant > 0) {
                    x1 = (-b + sqrtDiscriminant) / (2 * a);
                    x2 = (-b - sqrtDiscriminant) / (2 * a);
                    System.out.println(x1 + " " + x2);
                } else if (discriminant == 0) {
                    x1 = -b / (2 * a);
                    System.out.println(x1);
                } else {
                    System.out.println("корней нет");
        }
    }
}
