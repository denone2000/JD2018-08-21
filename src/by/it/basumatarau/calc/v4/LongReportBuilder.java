package by.it.basumatarau.calc.v4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;

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
        //todo
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
                while (buffR.ready() && (line = buffR.readLine()) != null) {
                    body.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        report.setBody(body.toString());
    }
    private static String getPath() {
        return System.getProperty("user.dir") + File.separator + "src" + File.separator
                + Logger.class.getName().replaceAll("[.]", File.separator).replaceAll(Logger.class.getSimpleName(), "");
    }

}
