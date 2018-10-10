package by.it.basumatarau.calc.v3;

import java.util.Locale;
import java.util.ResourceBundle;

enum CalcExceptionResManager {

    ENTITY;
    ResourceBundle resBundle;

    CalcExceptionResManager(){
        setLocale(Locale.getDefault());
    }
    void setLocale(Locale locale){
        resBundle = ResourceBundle.getBundle(
                "by/it/basumatarau/calc/v3/CalcExceptionResources/CalcExceptionResources",
                locale
        );
    }
    String getMsgByKey(String key){
        return resBundle.getString(key);
    }
}
