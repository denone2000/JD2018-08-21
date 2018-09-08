package by.it.akhmelev.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String cmd;
        Parser parser=new Parser();
        Printer printer=new Printer();
        while (!(cmd= scanner.next()).equalsIgnoreCase("END")){
            Var result=parser.calc(cmd);
            printer.print(result);
        }
    }
}
