package by.it.basumatarau.calc.v4;

import java.text.DateFormat;
import java.util.Date;

class Report {
    private DateFormat dtf;

    private String header;
    private Date startTime;
    private String body="";
    private Date finishTime;

    void setStartTime(Date startTime){
        this.startTime = startTime;
    }

    void setFinishTime(Date finishTime){
        this.finishTime = finishTime;
    }
    void setDateTimeFormat(DateFormat dtf){
        this.dtf = dtf;
    }

    void setBody(String body){
        this.body=body;
    }

    void setHeader(String header){
        this.header = header;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(header).append("\n");
        sb.append("Application start time:").append(dtf.format(startTime)).append("\n");
        sb.append("Application finish time:").append(dtf.format(finishTime)).append("\n");
        sb.append(body).append("\n");

        return sb.toString();
    }
}
