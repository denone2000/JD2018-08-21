package by.it.galushka.jd01_04;

public class Print {

    static void printTable(String[] next, int n, int[][] wages) {
        for (int i = 0; i < 60; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("%-10s%-11s%-11s%-11s%-11s%-5s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println();
        for (int i = 0; i < 60; i++) {
            System.out.print("-");
        }
        System.out.println();
        int total = 0;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            System.out.printf("%-8s%c ", next[i], ':');
            for (int j = 0; j < 4; j++) {
                System.out.printf("%-11d", wages[i][j]);
                sum = sum + wages[i][j];
            }
            System.out.printf("%-5d%n", sum);
            total = total + sum;
        }
        double avr = (double)total/(n*4);
        for (int i = 0; i < 60; i++) {
            System.out.print("-");
        }
        System.out.println();
        System.out.printf("%-10s%-11d%n", "Итого", total);
        System.out.printf("%-10s%-11.4f%n", "Средняя", avr);
    }
}
