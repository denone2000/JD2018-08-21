package by.it.artemliashkov.jd01_09;

import java.util.Scanner;
public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
            Var result = parser.calc(line);
            printer.Print(result);
        }
    }
}
