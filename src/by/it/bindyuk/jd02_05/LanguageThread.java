package by.it.bindyuk.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class LanguageThread extends Thread {
    private Scanner scanner = new Scanner(System.in);
    String lan;
    @Override
    public void run() {
        while (!(lan=scanner.nextLine()).equals("end")) {
            switch (lan) {
                case "ru": {
                    Res res = Res.INSTANCE;
                    res.setLocale(new Locale("ru", "RU"));
                    System.out.println(res.getKeys(Str.MSG_WELCOME));
                    System.out.println(res.getKeys(Str.MSG_QUESTION));
                    System.out.println(res.getKeys(Str.TXT_NAME));
                    break;
                }
                case "en": {
                    Res res = Res.INSTANCE;
                    res.setLocale(new Locale("en", "US"));
                    System.out.println(res.getKeys(Str.MSG_WELCOME));
                    System.out.println(res.getKeys(Str.MSG_QUESTION));
                    System.out.println(res.getKeys(Str.TXT_NAME));
                    break;
                }
                case "be": {
                    Res res = Res.INSTANCE;
                    res.setLocale(new Locale("be", "BY"));
                    System.out.println(res.getKeys(Str.MSG_WELCOME));
                    System.out.println(res.getKeys(Str.MSG_QUESTION));
                    System.out.println(res.getKeys(Str.TXT_NAME));
                    break;
                }
            }
        }
    }
}
