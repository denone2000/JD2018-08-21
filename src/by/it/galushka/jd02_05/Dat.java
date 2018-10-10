package by.it.galushka.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public enum Dat {

    INSTANCE;

    private Date now = new Date();

    private DateFormat df;

    void setDate(String dateFormat, Locale locale) {
        if (locale == null) {
            setDate(dateFormat);
        } else if (dateFormat.equalsIgnoreCase("full")) {
            df = DateFormat.getDateInstance(DateFormat.FULL, locale);
        } else if (dateFormat.equalsIgnoreCase("long")) {
            df = DateFormat.getDateInstance(DateFormat.LONG, locale);
        } else if (dateFormat.equalsIgnoreCase("medium")) {
            df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
        } else if (dateFormat.equalsIgnoreCase("short")) {
            df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
        } else
            df = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
    }

    void setDate(String dateFormat) {
        if (dateFormat.equalsIgnoreCase("full")) {
            df = DateFormat.getDateInstance(DateFormat.FULL);
        } else if (dateFormat.equalsIgnoreCase("long")) {
            df = DateFormat.getDateInstance(DateFormat.LONG);
        } else if (dateFormat.equalsIgnoreCase("medium")) {
            df = DateFormat.getDateInstance(DateFormat.MEDIUM);
        } else if (dateFormat.equalsIgnoreCase("short")) {
            df = DateFormat.getDateInstance(DateFormat.SHORT);
        } else
            df = DateFormat.getDateInstance(DateFormat.DEFAULT);
    }

    String getActualDate() {
        return df.format(now);
    }

}
