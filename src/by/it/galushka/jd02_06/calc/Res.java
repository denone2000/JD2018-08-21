package by.it.galushka.jd02_06.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Res {

    INSTANCE;

    private ResourceBundle rb;

    Res() {
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale locale){
        rb = ResourceBundle.getBundle("by.it.galushka.jd02_04.res.strings", locale);
    }

    String get(String key){
        return rb.getString(key);
    }
}
