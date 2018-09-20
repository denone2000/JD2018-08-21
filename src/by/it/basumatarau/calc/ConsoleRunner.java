package by.it.basumatarau.calc;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (!(str=scanner.nextLine()).trim().equalsIgnoreCase("end")){
            if (str.contains("printvar")){
                System.out.println(Var.printVar());
            }else if(str.contains("sortvar")){
                System.out.println(Var.sortvar());
            }else{
                try {
                    Var var = parser.calc(str);
                    System.out.println(printer.print(var));
                } catch (CalcException e){
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
