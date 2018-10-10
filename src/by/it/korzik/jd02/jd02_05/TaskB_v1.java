package by.it.korzik.jd02.jd02_05;

import by.it.korzik.jd02.jd02_05.Res;
import by.it.korzik.jd02.jd02_05.Str;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskB_v1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String lang;
        Res res = Res.INSTANCE;
        while (!((lang= scanner.next()).equals("end"))) {
            String country = getCountry(lang);
            Locale locale = new Locale(lang,country);
            res.setLocale(locale);
            DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM, res.getLocale());
            String date = dateFormat.format(new Date());
            System.out.println(date);
            System.out.println(res.get(Str.MSG_WELCOME));
            System.out.println(res.get(Str.MSG_QUESTION));
            System.out.println(res.get(Str.MSG_NAME));
        }
    }

    private static String getCountry(String lang) {
        String country="";
        switch (lang){
            case "ru": country= "RU"; break;
            case "en": country="US"; break;
            case "be": country="BY";break;
        }
        return country;
    }
}

