package by.it.basumatarau.calc.v3;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        Parser parser = new Parser();
        Printer printer = new Printer();


        while (!(str=scanner.nextLine()).trim().equalsIgnoreCase("end")){
            Logger logger = new Logger();
            logger.addMsg(str, Logger.MsgType.INPUT);
            if (str.contains("printvar")){
                System.out.println(Var.printVar());
                logger.addMsg(Var.printVar(), Logger.MsgType.OUTPUT);
            }else if(str.contains("sortvar")){
                System.out.println(Var.sortvar());
                logger.addMsg(Var.sortvar(), Logger.MsgType.OUTPUT);
            }else if(str.contains("ru")||str.contains("be")||str.contains("en")){
                CalcExceptionResManager.ENTITY.setLocale(new Locale(str));
            }
            else{
                try {
                    Var var = parser.calc(str);
                    System.out.println(printer.print(var));
                    logger.addMsg(printer.print(var), Logger.MsgType.OUTPUT);
                } catch (CalcException e){
                    logger.addMsg(e.getMessage(), Logger.MsgType.ERROR);
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
