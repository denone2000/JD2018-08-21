package by.it.galushka.jd02_05;

import java.util.Locale;

public class TaskA {

    public static void main(String[] args) {
        Res res = Res.INSTANCE;
        if (args.length == 2) {
            String language = args[0];
            String country = args[1];
            Locale locale = new Locale(language, country);
            res.setLocale(locale);
        }
        System.out.println(res.get(Messages.MSG_HELLO));
        System.out.println(res.get(Messages.MSG_MEET));
        System.out.println(res.get(Messages.MSG_NAME));

    }

}
