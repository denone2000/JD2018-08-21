package by.it.nesterovich.jd02_05.calc;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Res {

    INSTANCE;

    private ResourceBundle bundle;

    Res() {
        bundle = ResourceBundle.getBundle("by.it.nesterovich.jd02_05.calc.res.strings", Locale.getDefault());
    }

    void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle("by.it.nesterovich.jd02_05.calc.res.strings", locale);
    }

    String get(String key) {
        return bundle.getString(key);
    }
}
