package by.it.artemliashkov.jd01_02;

import java.util.Random;
import java.util.Scanner;

public class TaskC {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);
        int n;

        n = scanner.nextInt();
        int mas[][]=new int[n][n];
        mas=step1(n);
        System.out.println(mas);
        int sum=step2(mas);
        System.out.println(sum);
    }



    public static int[ ][ ] step1(int n) {
        int max=n;
        boolean IsTrue=true;
        int min=-n;
        int mas[][]=new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if(IsTrue) {
                        Random r = new Random();
                        mas[i][j] = r.nextInt(2 * n + 1) - n;
                        if ((mas[i][j] == n) || (mas[i][j] == -n)) {
                            IsTrue = false;
                        }
                        System.out.print(mas[i][j] + " ");
                    }
                }
                System.out.println();
            }
        return mas;
    }


    public static int step2(int  mas[][]) {
        int generalSum=0;
        for (int i=0; i<mas.length; i++) {
            int lineSum=0;
            boolean firstNotFound=true;
            boolean secondNotFound=true;
            int j=0;
            while (secondNotFound && j<mas.length) {
                if ( mas[i][j]>0 ) {
                    if (firstNotFound) {
                        firstNotFound=false;
                    }
                    else {
                        secondNotFound=false;
                    }
                } else if (!firstNotFound) {
                    lineSum+=mas[i][j];
                }
                j++;
            }
            if (!secondNotFound) {
                generalSum += lineSum;
            }
        }
        System.out.println(generalSum);
        return generalSum;

    }


}
