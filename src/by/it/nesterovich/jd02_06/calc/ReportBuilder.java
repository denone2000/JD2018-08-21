package by.it.nesterovich.jd02_06.calc;

abstract class ReportBuilder {

    StringBuilder report = new StringBuilder();

    abstract void titleReport(TitleType titleType);

    abstract void currentTime();

    abstract void massage(String message);

    String getReport() {
        return report.toString();
    }
}
