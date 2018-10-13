package by.it.voinilo.jd02.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner scanner=new Scanner(System.in);
        String cmd;
        Parser parser=new Parser();
        Printer printer=new Printer();
        while (!(cmd= scanner.next()).equalsIgnoreCase("END")){
            Var result= null;
            result = parser.calc(cmd);
            printer.print(result);
        }
    }
}
