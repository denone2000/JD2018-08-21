package by.it.yaroshchuk.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        Res res = Res.INSTANCE;
        String language = str;
        String country;
        if(str.equalsIgnoreCase("be"))
            country = "BY";
        else
            country = str.toUpperCase();

        res.setLocale(new Locale(language, country));
        System.out.println(res.get(Str.MSG_WELCOME));
        System.out.println(res.get(Str.MSG_QUESTION));
        System.out.println(res.get(Str.TXT_NAME));
    }
}
