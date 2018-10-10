package by.it.korolchuk.jd02_05;

import java.util.Locale;

public class TaskA {
    public static void main(String[] args) {
        Res res = Res.INSTANCE;
        if (args.length == 2) {
            String language=args[0];
            String country=args[1];
            Locale locale = new Locale(language, country);
            res.setLocale(locale);
        }
        System.out.println(res.get(Str.MSG_WELCOME));
        System.out.println(res.get(Str.MSG_QUESTION));
        System.out.println(res.get(Str.TXT_NAME));
    }
}
