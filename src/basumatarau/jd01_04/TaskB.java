package basumatarau.jd01_04;
import java.util.Random;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int personnerlAmount = Integer.parseInt(scanner.nextLine().trim());

        String[] personnelList = new String[personnerlAmount];

        for (int i = 0; i < personnelList.length; i++) {
            personnelList[i] = scanner.nextLine().trim();
        }
        int[][] payrollTable = new int[personnerlAmount][4];
        //Random rnd = new Random();
        for (int i =0; i < payrollTable.length; i++) {
            String[] splitLine = scanner.nextLine().trim().split(" ");
            for (int j =0; j < payrollTable[0].length; j++) {
        //        payrollTable[i][j] = (int) rnd.nextInt(25);
                payrollTable[i][j] = Integer.parseInt(splitLine[j]);
            }
        }
        printer(personnelList, payrollTable);
    }
    private static void printer(String[] personnelList, int[][] payrollTable){
        int total = 0,
            quarterTotal = 0;
        double avg = 0.0;

        System.out.println("------------------------------------------------------------");
        System.out.printf("%10s%10s%10s%10s%10s%10s%n", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("------------------------------------------------------------");
        for (int i = 0; i < personnelList.length; i++) {
            System.out.printf("%10s: ", personnelList[i]);
            quarterTotal = 0;
            for (int j = 0; j < payrollTable[i].length; j++) {
                total += payrollTable[i][j];
                quarterTotal += payrollTable[i][j];
                System.out.printf("%-10d ", payrollTable[i][j]);
            }
            System.out.printf("%-10d ", quarterTotal);
            System.out.print('\n');
        };
        System.out.println("------------------------------------------------------------");
        System.out.printf("%10s %-10d%n", "Итого", total);
        System.out.printf("%10s %-10f%n", "Средняя", (float)total/(payrollTable.length*payrollTable[0].length));

    }

}
