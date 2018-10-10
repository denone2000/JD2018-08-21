package by.it.galushka.jd02_06.TaskC;

public class Writter {

    private ReportBuilder reportBuilder;

    public void setReportBuilder(ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    public Report getReport() {
        return reportBuilder.getReport();
    }

    public void constructReport() {
        reportBuilder.createNewReportText();
        reportBuilder.headline();
        reportBuilder.startTime();
        reportBuilder.enteredExpression();
        reportBuilder.exceptions();
        reportBuilder.endTime();
    }
}
