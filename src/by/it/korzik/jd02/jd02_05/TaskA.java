package by.it.korzik.jd02.jd02_05;

import by.it.korzik.jd02.jd02_05.Res;
import by.it.korzik.jd02.jd02_05.Str;

import java.text.DateFormat;
import java.util.Date;
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
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, res.getLocale());
        String date = dateFormat.format(new Date());
        System.out.println(date);
        System.out.println(res.get(Str.MSG_WELCOME));
        System.out.println(res.get(Str.MSG_QUESTION));
        System.out.println(res.get(Str.MSG_NAME));

    }
}

