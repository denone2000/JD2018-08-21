package by.it.nesterovich.jd02_06.calc;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

class Logger {

    private static Logger instance;

    private Logger() {
    }

    static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    synchronized void writeReport(String message, TitleType titleType) {
        ReportBuilder reportBuilder = new ReportShortBuilder();
        //ReportBuilder reportBuilder = new ReportEntireBuilder();
        String title = reportBuilder.titleReport(titleType);
        String data = reportBuilder.currentTime();
        String mes = reportBuilder.massage(message);

        String path = System.getProperty("user.dir");
        path = path.concat("/src/by/it/nesterovich/jd02_06/calc/report.txt");

        try (PrintWriter out = new PrintWriter(new FileWriter(path, true))) {
            out.print(title);
            out.print("\t" + data);
            out.println("\t\t" + mes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
