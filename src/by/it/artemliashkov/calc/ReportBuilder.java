package by.it.artemliashkov.calc;

abstract class ReportBuilder {

    StringBuilder report = new StringBuilder();

    abstract void titleReport(String title);

    abstract void currentTime();

    abstract void message(String message);

    String getReport() {
        return report.toString();
    }
}
