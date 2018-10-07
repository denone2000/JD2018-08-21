package by.it.basumatarau.calc.v4;

import java.util.Date;

public class ShortReportBuilder extends ReportBuilder{

    @Override
    public void buildHeader() {
        report.setHeader("Short Header");
    }

    @Override
    public void buildStartTime() {
        report.setStartTime(new Date());
    }

    @Override
    public void buildBody() {

    }

    @Override
    public void buildFinishTime() {

    }
}
