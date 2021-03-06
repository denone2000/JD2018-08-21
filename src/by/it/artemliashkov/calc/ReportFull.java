package by.it.artemliashkov.calc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class ReportFull extends ReportBuilder  {
    private String message;
    private String title="Description";

    @Override
    void titleReport(String title) {
        this.title = title;
        report.append(title);
    }

    @Override
    void currentTime() {
        Date now = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(1, 1, Locale.getDefault());
        report.append("\t").append(dateFormat.format(now));
    }

    @Override
    void message(String message) {
        String mes = message;
        report.append("\t").append(mes);
    }
}
