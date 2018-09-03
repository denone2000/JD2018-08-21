package by.it.yaroshchuk.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String [] surnameArray = new String [n];

        for (int i = 0; i < surnameArray.length; i++) {
            surnameArray[i] = scanner.next();
        }

        for (String s : surnameArray) {
            System.out.println(s);
        }

        int [][] salaryArray = new int [n][4];

        for (int i = 0; i < surnameArray.length; i++) {
            System.out.println("Enter " + surnameArray[i] + " salary");
            for (int j = 0; j < salaryArray[0].length; j++){
                salaryArray[i][j] = scanner.nextInt();
            }
        }
        int[ ] salarySum = new int[salaryArray[0].length];
        for (int i = 0; i < salaryArray.length; i++) {
            for (int j = 0; j < salaryArray[0].length; j++) {
                salarySum[i] += salaryArray[i][j];
            }
        }
        printSalaryTable(surnameArray, salaryArray, salarySum);
    }

    public static void printSalaryTable(String []surnameArray, int[][] salaryArray, int [] salarySum){
        System.out.printf("------------------------------------------------------%n");
        System.out.printf("%-9s%-10s%-10s%-10s%-10s%-5s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.printf("------------------------------------------------------%n");
        for (int i = 0; i < surnameArray.length; i++) {
            System.out.printf("%9s%-10d%-10d%-10d%-10d%-5d%n", surnameArray[i] + ": ", salaryArray[i][0], salaryArray[i][1],
                    salaryArray[i][2], salaryArray[i][3], salarySum[i]);
        }
        System.out.printf("------------------------------------------------------%n");

        int sum = 0;
        for (int i : salarySum) {
            sum += i;
        }
        double avg = (double) sum/(salaryArray.length * salaryArray[0].length);

        System.out.printf("%-9s%-10d%n", "Итого: ", sum);
        System.out.printf("%-9s%-2.6f", "Средняя: ", avg);
    }
}
