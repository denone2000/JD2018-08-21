package by.it.galushka.jd02_04;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {

    private static Res res = Res.INSTANCE;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Parser parser = new Parser();
        Printer printer = new Printer();
        Res res = Res.INSTANCE;
        if (args.length == 2) {
            String language = args[0];
            String country = args[1];
            Locale locale = new Locale(language, country);
            res.setLocale(locale);
        }
        System.out.println(res.get(Messages.MSG_ERROR_ENTER));
        while (!(line = scanner.nextLine()).equals(res.get(Messages.MSG_ERROR_END))) {
            boolean local = chooseLocal(line);
            if (local) {
                if (line.equals("printvar")) {
                    System.out.println(Var.printVar());
                } else {
                    try {
                        Var result = parser.calc(line.trim());
                        printer.print(result);
                    } catch (CalcException e) {
                        System.out.println(e.getMessage());
                    }
                }
            } else {
                System.out.println(res.get(Messages.MSG_ERROR_ENTER));
                System.out.println(res.get(Messages.MSG_ERROR_EXIT));
            }
        }
    }

    private static boolean chooseLocal(String loc) {
        boolean local = true;
        Locale locale = null;
        if (loc.equalsIgnoreCase("en")) {
            locale = new Locale("en", "EN");
            res.setLocale(locale);
            local = false;
        } else if (loc.equalsIgnoreCase("ru")) {
            locale = new Locale("ru", "RU");
            res.setLocale(locale);
            local = false;
        } else if (loc.equalsIgnoreCase("be")) {
            locale = new Locale("be", "BY");
            res.setLocale(locale);
            local = false;
        }
        return local;
    }
}
