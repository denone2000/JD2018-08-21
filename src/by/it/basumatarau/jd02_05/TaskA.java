package by.it.basumatarau.jd02_05;

import java.util.Locale;

public class TaskA {
    public static void main(String[] args) {

        ResourceManager resMan = ResourceManager.ENTITY;

        if(args.length==2){
            resMan.setLocale(new Locale(args[0], args[1]));
        }

        System.out.println(resMan.get(Str.MSG_WELCOME));
        System.out.println(resMan.get(Str.MSG_QUESTION));
        System.out.println(resMan.get(Str.MSG_NAME));
    }
}
