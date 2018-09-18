package by.it.bindyuk.calc;

import java.util.Map;
import java.util.Scanner;


public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cmd;
        String mapper;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(cmd = scanner.nextLine()).equals("end")) {
            if ((mapper = scanner.nextLine()).equals("printvar")) {
                for (Map.Entry<String, Var> elementFromMap : Var.getVars().entrySet()) {
                    String key = elementFromMap.getKey();
                    Var value = elementFromMap.getValue();
                    System.out.println(key + " " + value);
                }

            } break;
        }
        Var result = parser.calc(cmd.trim());
        printer.print(result);
    }
}
