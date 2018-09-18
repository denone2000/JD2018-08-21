package by.it.galushka.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(line = scanner.nextLine()).equals("end")) {
            if (line.equals("printvar")) {
                System.out.println(Var.printVar());
            }
            else if (line.equals("sortvar")) {
                System.out.println("Функция пока не работает!");
            }
            else {
                Var resault = parser.calc(line.trim());
                printer.print(resault);
            }
        }
    }
}
