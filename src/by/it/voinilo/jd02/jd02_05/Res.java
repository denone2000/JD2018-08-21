package by.it.voinilo.jd02.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Res {
    INSTANCE;

    private ResourceBundle bundle;

    private Res(){
        setLocale (Locale.getDefault());

    }

    void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle("by.it.voinilo.jd02.jd02_05.res.strings", locale);

    }

    String get (String key) {
        bundle.getString(key);
        return bundle.getString(key);

    }
}
