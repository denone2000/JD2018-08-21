package by.it.korolchuk.jd02_05;


import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args){
        Res res = Res.INSTANCE;
        DateFormat df = DateFormat.getDateInstance();
        Date date = new Date();

        Scanner sc = new Scanner(System.in);
        String loc = sc.nextLine();

        String in = System.getProperty("user.dir") + "/src/by/it/korolchuk/jd02_05/txt/convertor.bat";
        String out = System.getProperty("user.dir") + "/src/by/it/korolchuk/jd02_05/txt/commands.txt";

        if (args.length == 2) {
            String language = args[0];
            String country = args[1];
            Locale locale = new Locale(language, country);
            res.setLocale(locale);
            df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.US);

        }

        switch (loc) {
            case "ru": {
                res.setLocale(new Locale("ru", "RU"));
                df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("ru", "RU"));
                break;
            }
            case "en": {
                res.setLocale(new Locale("en", "US"));
                df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("en", "US"));
                break;
            }
            case "be": {
                res.setLocale(new Locale("be", "BY"));
                df = DateFormat.getDateInstance(DateFormat.LONG, new Locale("be", "BY"));
                break;
            }
        }

        System.out.println(res.get(Str.MSG_WELCOME));
        System.out.println(res.get(Str.MSG_QUESTION));
        System.out.println(res.get(Str.TXT_NAME));
        System.out.println(df.format(date));

        try(BufferedReader reader = new BufferedReader(new FileReader(in));
            PrintWriter writer = new PrintWriter(new FileWriter(out))){
            StringBuilder sb = new StringBuilder();
            while (reader.ready()){
                sb.append(reader.readLine()).append('\n');
            }
            writer.println(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
