package by.it.akhmelev.calc.v3;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String cmd;
        Parser parser=new Parser();
        Printer printer=new Printer();
        while (!(cmd= scanner.next()).equalsIgnoreCase("END")){
            Var result= null;
            try {
                result = parser.calc(cmd);
            } catch (by.it.akhmelev.calc.v3.CalcException e) {
                System.out.println(e.getMessage());
            }
            printer.print(result);
        }
    }
}