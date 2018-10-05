package by.it.nesterovich.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String line;
        System.out.println("Для завершения программы введите: end");
        System.out.println("Для переключения языка приветствие введите одну из команд: ru be en");
        while (!(line = scanner.nextLine()).equalsIgnoreCase("end")) {
            Locale locale = new Locale(line);
            writeToConsole(locale);
        }
    }

    private static void writeToConsole(Locale locale) {
        Res res = Res.INSTANCE;
        Date now = new Date();
        res.setLocale(locale);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG, locale);

        System.out.println(res.get(Str.MSG_WELCOME));
        System.out.println(res.get(Str.MSG_QUESTION));
        System.out.println(res.get(Str.TXT_NAME));
        System.out.println(dateFormat.format(now));
    }
}
