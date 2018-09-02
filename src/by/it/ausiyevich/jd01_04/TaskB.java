package by.it.ausiyevich.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
            Scanner scanner=new Scanner(System.in);
            int n = scanner.nextInt();
            String[] fam=new String[n];
            for (int i = 0; i < fam.length; i++) {
                fam[i]=scanner.next();
            }
            int[][] z=new int[n][4];
            for (int i = 0; i < fam.length; i++) {
                System.out.println("Input for "+fam[i]);
                for (int j = 0; j < 4; j++) {
                    z[i][j]=scanner.nextInt();
                }
            }

            System.out.println("----------------------------------");
            System.out.println("------1-----2------3------4-------");
            System.out.println("----------------------------------");
            int sumAll=0;
            for (int i = 0; i < fam.length; i++) {
                System.out.printf("%12s",fam[i]);
                int sum=0;
                for (int j = 0; j < z[i].length; j++) {
                    System.out.printf(" %-11d",z[i][j]);
                    sum+=z[i][j];
                }
                System.out.printf(" %-11d\n",sum);

                sumAll+=sum;
            }
            System.out.printf("Sum All=%d\n    Avg=%10.6f",sumAll,sumAll/4.0/n);

        }
    }