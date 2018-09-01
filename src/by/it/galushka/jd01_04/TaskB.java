package by.it.galushka.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("Введите количество человек:");
        int n = scanner.nextInt();
        System.out.println("Введите 1-ую фамилию:");
        String people = scanner.next();
        if(n > 1) {
            for (int i = 1; i < n; i++) {
                System.out.println("Введите "+(i+1)+"-ую "+"фамилию:");
                people = people + " " + scanner.next();
            }
        }
        String[] next = people.trim().split(" ");
        int[][] wages = new int[n][4];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите зарплату для "+next[i]);
            for (int j = 0; j < 4; j++) {
                wages[i][j] = scanner.nextInt();
            }
        }
        Print.printTable(next, n, wages);
    }
}


