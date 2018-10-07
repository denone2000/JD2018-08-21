package by.it.basumatarau.calc.v4;

public abstract class ReportBuilder {
    Report report;

    Report getReport(){
        return report;
    }
    public void createNewReport(){
        report = new Report();
    }

    public abstract void buildHeader();
    public abstract void buildStartTime();
    public abstract void buildBody();
    public abstract void buildFinishTime();
    public abstract void buildDateTimeFormat();
}
