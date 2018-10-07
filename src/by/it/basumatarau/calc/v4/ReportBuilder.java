package by.it.basumatarau.calc.v4;

public abstract class ReportBuilder {
    Report report;

    public Report getReport(){
        return report;
    }
    public void createNewReport(){
        report = new Report();
    }

    /*
    public void setHeader(String header){
        this.header = header;
    }
    public void setDate(Date startTime){
        this.startTime = startTime;
    }
    public void setFinishTime(Date finishTime){
        this.finishTime = finishTime;
    }
    public void setDateTimeFormat(DateFormat dtf){
        this.dtf = dtf;
    }
    */

    public abstract void buildHeader();
    public abstract void buildStartTime();
    public abstract void buildBody();
    public abstract void buildFinishTime();

}
