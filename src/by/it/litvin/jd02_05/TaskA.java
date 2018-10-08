package by.it.litvin.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class TaskA {
    public static void main(String[] args) {
        Locale locale=new Locale("ru","RU");
//        ResourceBundle.getBundle()
        System.out.println(Str.MSG_WELCOME);
        System.out.println(Str.MSG_QUESTION);
        System.out.println(Str.TXT_NAME);
    }
}
