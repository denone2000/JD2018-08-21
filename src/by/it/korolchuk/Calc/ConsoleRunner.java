package by.it.korolchuk.Calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cmd;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(cmd = sc.next()).equalsIgnoreCase("END")) {
            Var result = parser.calc(cmd);
            printer.print(result);
        }
    }
}
