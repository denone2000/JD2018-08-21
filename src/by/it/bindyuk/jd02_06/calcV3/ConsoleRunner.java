package by.it.bindyuk.jd02_06.calcV3;

import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

import static by.it.bindyuk.jd02_06.calcV3.Var.vars;


public class ConsoleRunner {
    static ResCalc res = ResCalc.INSTANCE;
    static Logger logger;

    public static void main(String[] args) {
        logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        String cmd;
        Parser parser = new Parser();
        Printer printer = new Printer();
        res.setLocale(new Locale("en", "US"));
        while (!(cmd = scanner.nextLine()).equals("end")) {

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

            if (cmd.equals("printvar")) {
                for (Map.Entry<String, Var> entries : vars.entrySet()) {
                    System.out.println(entries.getKey() + "=" + entries.getValue());
                }
                break;
            }
            try {
                Var result = parser.calc(cmd.trim());
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }

        }
    }
}
