package by.it.nesterovich.jd02_06.calc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class ReportShortBuilder extends ReportBuilder {

    private TitleType titleType;

    @Override
    void titleReport(TitleType titleType) {
        this.titleType = titleType;
        report.append(titleType);
    }

    @Override
    void currentTime() {
        Date now = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, 3, Locale.getDefault());
        report.append("\t").append(dateFormat.format(now));
    }

    @Override
    void massage(String message) {
        String mes = message;
        if (this.titleType.equals(TitleType.ERROR)) {
            mes = String.valueOf(TitleType.ERROR);
        }
        report.append("\t").append(mes);
    }
}
