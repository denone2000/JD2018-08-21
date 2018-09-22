package by.it.bindyuk.calc;

import java.util.Map;
import java.util.Scanner;

import static by.it.bindyuk.calc.Var.vars;


public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cmd;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(cmd = scanner.nextLine()).equals("end")) {
            if(cmd.equals("printvar")){
                for(Map.Entry<String, Var> entries : vars.entrySet()){
                    System.out.println(entries.getKey()+"="+entries.getValue());
                }
                break;
            }
            try {
                Var result =  parser.calc(cmd.trim());
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
