package by.it.voinilo.jd02.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class TaskA {

    public static void main(String[] args){
        Res res = Res.INSTANCE;
        res.setLocale(new Locale("ru", "RU"));
        if (args.length ==2){
        String lang = args[0];
        String country = args[1];
        Locale locale = new Locale(lang, country);
        res.setLocale(locale);

        }

         System.out.println (res.get(Str.MSG_WELCOME));
        System.out.println(res.get(Str.MSG_QUESTION));
        System.out.println(res.get(Str.TXT_NAME));

    }

}
