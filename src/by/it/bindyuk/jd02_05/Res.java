package by.it.bindyuk.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public enum Res {
    INSTANCE;

    private ResourceBundle bundle;

    private Res(){

    }

    void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle("by.it.bindyuk.jd02_05.res.strings",locale);
    }

    String getKeys(String key){
        return bundle.getString(key);
    }

}
