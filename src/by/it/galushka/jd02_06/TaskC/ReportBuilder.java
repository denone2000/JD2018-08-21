package by.it.galushka.jd02_06.TaskC;

public abstract class ReportBuilder {

    Report report;

    public Report getReport(){
        return report;
    }

    void createNewReportText(){
        report = new Report();
    }

    public abstract void headline();
    public abstract void startTime();
    public abstract void enteredExpression();
    public abstract void exceptions();
    public abstract void endTime();
}
