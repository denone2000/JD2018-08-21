package by.it.litvin.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while (!(line = scanner.nextLine()).equals("end")) {
            try {
                Var result = parser.calc(line);
                logger.log("result" + result.toString());
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }


        }
    }
}
