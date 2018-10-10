package by.it.korzik.jd02.jd02_04;

import by.it.korzik.jd02.jd02_04.CalcException;
import by.it.korzik.jd02.jd02_04.Parser;
import by.it.korzik.jd02.jd02_04.Printer;
import by.it.korzik.jd02.jd02_04.Var;

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
