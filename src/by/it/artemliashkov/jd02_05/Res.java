package by.it.artemliashkov.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum  Res {

    INSTANCE;

    private ResourceBundle bundle;
    private Locale locale;

    public Locale getLocale() {
        return locale;
    }

    Res() {
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale locale){
        this.locale=locale;
        bundle = ResourceBundle.getBundle("by.it.artemliashkov.jd02_05.res.strings", locale);
    }

    String get(String key){
        return bundle.getString(key);
    }


}
