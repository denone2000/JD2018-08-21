package by.it.korolchuk.jd02_06;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Res {

    INSTANCE;

    private ResourceBundle bundle;

    Res() {
        setLocale(Locale.getDefault());
    }

    void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle(
                "by.it.korolchuk.jd02_05.Calc_jd02_05.res.strings", locale
        );
    }

    String get(String key){
        return bundle.getString(key);
    }


}
