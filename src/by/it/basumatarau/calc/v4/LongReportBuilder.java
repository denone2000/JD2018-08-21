package by.it.basumatarau.calc.v4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LongReportBuilder extends ReportBuilder {

    @Override
    public void buildHeader() {
        report.setHeader("======Long Header======");
    }

    @Override
    public void buildDateTimeFormat() {
        report.setDateTimeFormat(DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG));
    }

    @Override
    public void buildStartTime() {
        File file = new File(getPath()+"log.txt");
        String line="";
        if(file.exists()) {
            try (BufferedReader buffR = new BufferedReader(new FileReader(file))) {
                while (buffR.ready() && (line = buffR.readLine()) != null) {
                    if (line.matches("^\\[session start\\].*")) {
                        line = line.substring(15);
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);
            report.setStartTime(sdf.parse(line));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildFinishTime() {
        report.setFinishTime(new Date());
    }

    @Override
    public void buildBody() {
        File file = new File(getPath()+"log.txt");
        StringBuilder body = new StringBuilder();
        if(file.exists()) {
            try (BufferedReader buffR = new BufferedReader(new FileReader(file))) {
                String line;
                Date sessionStart= getSessionStartDate(buffR);
                SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);

                boolean isReported = false;
                while (buffR.ready() && (line = buffR.readLine()) != null) {

                    Date msgDate=null;
                    try {
                        msgDate=sdf.parse(line.substring(10));
                    }catch (ParseException e) {
                        e.printStackTrace();
                    }

                    if(line.matches("(^\\[session start\\].*)")) isReported=false;
                    if(line.matches("(^\\[input\\].*)|(^\\[error\\].*)|(^\\[output\\].*)")&&
                            msgDate!=null&&
                            msgDate.after(sessionStart)) isReported=true;
                    if(isReported) body.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        report.setBody(body.toString());
    }
    private Date getSessionStartDate(BufferedReader buffR) throws IOException {
        Date sessionStart = null;
        String line;
        while (buffR.ready() && (line = buffR.readLine()) != null) {
            if (line.matches("^\\[session start\\].*")) {
                line = line.substring(15);
                try {
                    SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);
                    sessionStart=sdf.parse(line);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            }
        }
        return sessionStart;
    }
    private static String getPath() {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator
                + Logger.class.getName().replaceAll("[.]", File.separator).replaceAll(Logger.class.getSimpleName(), "");
    }

}
