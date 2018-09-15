package by.it.korzik.jd01_09;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Parser parser=new Parser();
        Printer printer = new Printer();
        String cmd;
        while (!(cmd=scan.next()).equalsIgnoreCase("end")){
        Var result = parser.calc(cmd);
        printer.print(result);
        }
    }
}
