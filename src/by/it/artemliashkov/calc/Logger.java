package by.it.artemliashkov.calc;

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

    synchronized void log(String message) {
        String title="Description";
        ReportBuilder reportBuilder = new ReportShort();
        reportBuilder.titleReport(title);
        reportBuilder.currentTime();
        reportBuilder.message(message);
        String path = System.getProperty("user.dir");
        path = path.concat("/src/by/it/artemliashkov/calc/log.txt");
        Date now = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, 2, Locale.getDefault());
        try (PrintWriter out = new PrintWriter(new FileWriter(path, true))) {
            out.print(dateFormat.format(now));
            out.println("\t\t" + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}