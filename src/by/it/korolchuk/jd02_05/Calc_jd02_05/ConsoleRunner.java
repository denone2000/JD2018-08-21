package by.it.korolchuk.jd02_05.Calc_jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        CalcLogger logger = CalcLogger.getInstance();
        Scanner sc = new Scanner(System.in);
        String cmd;
        Parser parser = new Parser();
        Printer printer = new Printer();
        Res res = Res.INSTANCE;
        //res.setLocale(new Locale("en", "US"));
        while (!(cmd = sc.next()).equalsIgnoreCase("END")) {
            logger.log("input operation " + cmd);
            switch (cmd) {
                case "ru": {
                    res.setLocale(new Locale("ru", "RU"));
                    break;
                }
                case "en": {
                    res.setLocale(new Locale("en", "US"));
                    break;
                }
                case "be": {
                    res.setLocale(new Locale("be", "BY"));
                    break;
                }
            }
            try {
                Var result = parser.calc(cmd);
                logger.log("result " + result.toString());
                printer.print(result);
            } catch (Exception e) {
                logger.log(e.getMessage());
               System.out.println(e.getMessage());
            }
        }
    }
}
