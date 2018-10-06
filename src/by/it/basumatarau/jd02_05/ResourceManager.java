package by.it.basumatarau.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

enum ResourceManager {

    ENTITY;

    private ResourceBundle bundle;
    ResourceManager(){
        setLocale(Locale.getDefault());
    }

    public void setLocale(Locale locale){
        bundle = ResourceBundle.getBundle("by.it.basumatarau.jd02_05.resources.Strings",
                locale
        );
    }

    String get(String key){
        return bundle.getString(key);
    }
}
