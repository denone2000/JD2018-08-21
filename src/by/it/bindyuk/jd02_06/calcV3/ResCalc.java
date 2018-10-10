package by.it.bindyuk.jd02_06.calcV3;

import java.util.Locale;
import java.util.ResourceBundle;

public enum ResCalc {
    INSTANCE;

    private ResourceBundle bundle;

    void setLocale(Locale locale) {
        bundle = ResourceBundle.getBundle("by.it.bindyuk.jd02_04.calcV2.res.strings", locale);
    }

    String getKeys(String key) {
        return bundle.getString(key);
    }
}

