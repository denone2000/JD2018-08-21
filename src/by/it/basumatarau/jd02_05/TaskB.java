package by.it.basumatarau.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str;
        ResourceManager resMan = ResourceManager.ENTITY;
        DateFormat df = DateFormat.getDateInstance();

        if (args.length == 2) {
            df = DateFormat.getDateInstance(DateFormat.FULL, new Locale(args[0], args[1]));
            resMan.setLocale(new Locale(args[0], args[1]));
        }

        while(!(str = scanner.nextLine()).toLowerCase().contains("end")){
            if(str.equals("en")||str.equals("ru")||str.equals("be")){
                df = DateFormat.getDateInstance(DateFormat.FULL, new Locale(str));
                resMan.setLocale(new Locale(str));
            }

            System.out.println(resMan.get(Str.MSG_WELCOME));
            System.out.println(resMan.get(Str.MSG_QUESTION));
            System.out.println(resMan.get(Str.MSG_NAME));

            System.out.println(df.format(new Date()));
        }
    }
}
