package by.it.basumatarau.calc.v4;

class ReportBldDirector {
    private ReportBuilder reportBuilder;

    void setReportBuilder(ReportBuilder rb){
        reportBuilder = rb;
    }

    Report getReport(){
        return reportBuilder.getReport();
    }

    void buildNewReport(){
        reportBuilder.createNewReport();
        reportBuilder.buildDateTimeFormat();
        reportBuilder.buildHeader();
        reportBuilder.buildStartTime();
        reportBuilder.buildFinishTime();
        reportBuilder.buildBody();
    }
}
