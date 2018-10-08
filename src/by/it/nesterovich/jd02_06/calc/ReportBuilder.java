package by.it.nesterovich.jd02_06.calc;

abstract class ReportBuilder {

    abstract String titleReport(TitleType titleType);

    abstract String currentTime();

    abstract String massage(String message);
}
