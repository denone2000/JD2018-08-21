package by.it.korzik.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Scanner;

public class TaskB_v2 {

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
        HashMap<String, String> map = new HashMap<>();
        map.put("ru","RU");
        map.put("en","US");
        map.put("be","BY");
        return map.get(lang);
    }
}

