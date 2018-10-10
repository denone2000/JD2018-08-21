package by.it.litvin.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    private static String country = "";

    public static String getCountry(String lang) {
        switch (lang) {
            case "ru":
                country = "RU";
                break;
            case "en":
                country = "US";
                break;
            case "be":

                country = "BE";
                break;
        }

        return country;
    }

    public static void main(String[] args) {
        Res res = Res.INSTANCE;
        Scanner scanner = new Scanner(System.in);
        String lang;
        while (!((lang = scanner.next()).equalsIgnoreCase("end"))) {
            String country = getCountry(lang);
            Locale locale = new Locale(lang, country);
            res.setLocale(locale);
        }
        DateFormat dateFormat=DateFormat.getDateInstance(DateFormat.MEDIUM,res.getLocale());
        String date=dateFormat.format(new Date());
        System.out.println(date);
        System.out.println(res.get(Str.MSG_WELCOME));
        System.out.println(res.get(Str.MSG_QUESTION));
        System.out.println(res.get(Str.TXT_NAME));



        }
    }



