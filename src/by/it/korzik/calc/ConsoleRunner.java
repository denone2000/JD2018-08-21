package by.it.korzik.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Parser parser=new Parser();
        Printer printer = new Printer();
        String cmd;
        while (!(cmd=scan.next()).equalsIgnoreCase("end")){
            Var result= null;
            try {
         result = parser.calc(cmd);}
        catch (CalcException e){
            System.out.println(e.getMessage());
        }
            printer.print(result);
        }
    }
}
