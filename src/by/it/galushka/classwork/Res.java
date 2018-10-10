package by.it.galushka.classwork;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Res {

    INSTANSE;

    private ResourceBundle bundle;

    Res() {
         bundle = ResourceBundle.getBundle(
                "by.it.galushka.classwork.txt.string", Locale.getDefault()
        );
    }

    void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle(
                "by.it.galushka.classwork.txt.string", locale
        );
    }
}
