package by.it.voinilo.jd02.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Res res = Res.INSTANCE;

        res.setLocale(new Locale("ru"));

        System.out.println("Выберите язык ru, be, en");
        Scanner scanner = new Scanner(System.in);
        String lang = scanner.next();
        Locale locale = new Locale (lang);

        res.setLocale(locale);
        System.out.println(res.get(Str.TXT_DATE));
    }
}
