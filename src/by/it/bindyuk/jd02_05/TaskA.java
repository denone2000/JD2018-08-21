package by.it.bindyuk.jd02_05;

import java.io.*;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class TaskA {
    public static void main(String[] args) {
        //поток для переключения локали
        LanguageThread thread = new LanguageThread();
        thread.start();

        //запись команд из convertor.bat в команды.txt

        String input = System.getProperty("user.dir") + "/src/by/it/bindyuk/jd02_05/txt/convertor.bat";
        String output = System.getProperty("user.dir") + "/src/by/it/bindyuk/jd02_05/txt/команды.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(input));
            PrintWriter writer = new PrintWriter(new FileWriter(output))){
            StringBuilder sb = new StringBuilder();
            while (reader.ready()){
                sb.append(reader.readLine()).append('\n');
            }
            writer.println(sb.toString());

        } catch (IOException e) {
            e.printStackTrace();
        }

        //вывод даты и приветствия в консоль + вывод даты

        Res res = Res.INSTANCE;
        if (args.length == 2) {
            String language = args[0];
            String country = args[1];
            Locale locale = new Locale(language, country);
            Date date = new Date();
            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
            System.out.println(df.format(date));
            res.setLocale(locale);
        }
        if (args.length == 0) {
            res.setLocale(new Locale("en", "US"));
            Date date = new Date();
            DateFormat df = DateFormat.getDateInstance(DateFormat.MEDIUM, new Locale("en", "US"));
            System.out.println(df.format(date));
        }
        System.out.println(res.getKeys(Str.MSG_WELCOME));
        System.out.println(res.getKeys(Str.MSG_QUESTION));
        System.out.println(res.getKeys(Str.TXT_NAME));
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
