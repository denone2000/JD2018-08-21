package by.it.basumatarau.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(str=scanner.nextLine()).trim().equalsIgnoreCase("end")){
            Var var = parser.calc(str);
            System.out.println(printer.print(var));
        }
    }
}
