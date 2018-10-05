package by.it.galushka.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Res res = Res.INSTANCE;

        if (args.length == 2) {
            String language = args[0];
            String country = args[1];
            Locale locale = new Locale(language, country);
            res.setLocale(locale);
        }
        System.out.println(res.get(Messages.MSG_ENTER));
        String inputLocal;
        while (!(inputLocal = scanner.nextLine()).equalsIgnoreCase("end")) {
            if (inputLocal.equals("конец")) {
                break;
            } else if (inputLocal.equals("канец")) {
                break;
            } else
                chooseLocal(res, inputLocal);
        }
    }

    private static void chooseLocal(Res res, String loc) {
        Dat date = Dat.INSTANCE;
        
        Locale locale = null;
        if (loc.equalsIgnoreCase("en")) {
            locale = new Locale("en", "EN");
            res.setLocale(locale);
            doIt(res, date, locale);
        } else if (loc.equalsIgnoreCase("ru")) {
            locale = new Locale("ru", "RU");
            res.setLocale(locale);
            doIt(res, date, locale);
        } else if (loc.equalsIgnoreCase("be")) {
            locale = new Locale("be", "BY");
            res.setLocale(locale);
            doIt(res, date, locale);
        } else
            System.out.println(res.get(Messages.MSG_WARNING));
    }

    private static void doIt(Res res, Dat date, Locale locale) {
        date.setDate("full", locale);
        printMessagesAndDate(res, date);
    }

    private static void printMessagesAndDate(Res res, Dat date) {
        System.out.println(res.get(Messages.MSG_HELLO));
        System.out.println(res.get(Messages.MSG_MEET));
        System.out.println(res.get(Messages.MSG_NAME));
        System.out.println(res.get(Messages.MSG_TODAY) + " " + date.getActualDate());
        System.out.println();
        System.out.println(res.get(Messages.MSG_ENTER));
        System.out.println(res.get(Messages.MSG_EXIT));
    }
}
