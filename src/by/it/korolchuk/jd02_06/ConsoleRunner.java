package by.it.korolchuk.jd02_06;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        CalcLogger logger = CalcLogger.getInstance();
        Scanner sc = new Scanner(System.in);
        String cmd;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(cmd = sc.next()).equalsIgnoreCase("END")) {
            logger.log("input operation " + cmd);
            try {
                Var result = parser.calc(cmd);
                logger.log("result " + result.toString());
                printer.print(result);
            } catch (Exception e) {
                logger.log(e.getMessage());
                System.out.println(e.getMessage());
            }
        }
    }
}
