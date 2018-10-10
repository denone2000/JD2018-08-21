package by.it.artemliashkov.calc;

import java.util.Scanner;


public class ConsoleRunner{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        Logger logger = Logger.getInstance();
        while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
            try {
                logger.log(line);
                Var result = parser.calc(line);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                e.printStackTrace();
            }

        }
    }
}
