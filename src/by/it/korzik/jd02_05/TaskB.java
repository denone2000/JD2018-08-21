package by.it.korzik.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lang = scanner.next();
        Res res = Res.INSTANCE;
        Locale locale = new Locale(lang);
        res.setLocale(locale);
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, res.getLocale());
        String date = dateFormat.format(new Date());
        System.out.println(date);
        System.out.println(res.get(Str.MSG_WELCOME));
        System.out.println(res.get(Str.MSG_QUESTION));
        System.out.println(res.get(Str.MSG_NAME));

    }
}

