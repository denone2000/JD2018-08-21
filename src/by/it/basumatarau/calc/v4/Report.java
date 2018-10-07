package by.it.basumatarau.calc.v4;

import java.text.DateFormat;
import java.util.Date;

class Report {
    private DateFormat dtf; // = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM)

    private String header;
    private Date startTime;
    private StringBuilder body;
    private Date finishTime;

    public enum MsgType{
        INPUT, ERROR, OUTPUT
    }

    public void setHeader(String header){
        this.header = header;
    }
    public void setStartTime(Date startTime){
        this.startTime = startTime;
    }
    public void setFinishTime(Date finishTime){
        this.finishTime = finishTime;
    }
    public void setDateTimeFormat(DateFormat dtf){
        this.dtf = dtf;
    }

    public void addMsg(String msg, MsgType type){
        switch (type){
            case INPUT:
                body.append(dtf.format(new Date())).append("input: ").append(msg).append("\n");
                break;
            case OUTPUT:
                body.append(dtf.format(new Date())).append("output:").append(msg).append("\n");
                break;
            case ERROR:
                body.append(dtf.format(new Date())).append("error: ").append(msg).append("\n");
                break;
                default:
                body.append(dtf.format(new Date())).append("input: ").append(msg).append("\n");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(header).append("\n");
        sb.append("Application start time:").append(dtf.format(startTime)).append("\n");

        //sb.append()

        sb.append("Application finish time:").append(dtf.format(finishTime)).append("\n");

        return sb.toString();
    }
}
